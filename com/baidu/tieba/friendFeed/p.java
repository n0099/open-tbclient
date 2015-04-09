package com.baidu.tieba.friendFeed;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private final FriendFeedActivity aHV;
    private boolean aHW;
    private boolean aHX;
    private boolean aHZ;
    private final int aIb;
    private final int aIc;
    private boolean aId;
    private v aIf;
    private ListView mListView;
    private boolean mIsFromCDN = false;
    private ArrayList<IconData> aIa = null;
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private View.OnClickListener aIe = new q(this);
    private ArrayList<FriendFeedThreadData> aHY = new ArrayList<>();

    public p(FriendFeedActivity friendFeedActivity, int i, boolean z) {
        this.aHZ = false;
        this.aHV = friendFeedActivity;
        this.aHZ = z;
        bG(z);
        this.aIb = this.aHV.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.aIc = this.aHV.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
    }

    public void bG(boolean z) {
        if (this.aHZ != z) {
            this.aHZ = z;
        }
    }

    public void a(com.baidu.tieba.friendFeed.data.a aVar) {
        this.aHY.addAll(aVar.Jo());
    }

    public ArrayList<FriendFeedThreadData> IY() {
        return this.aHY;
    }

    public void reset(boolean z) {
        if (z) {
            this.aHY.clear();
            this.aHX = false;
            return;
        }
        this.aHX = true;
    }

    public void bH(boolean z) {
        this.aHX = z;
    }

    public boolean IZ() {
        return this.aHW;
    }

    public void bI(boolean z) {
        this.aHW = z;
    }

    public String Ja() {
        return this.aHY.size() > 0 ? this.aHY.get(this.aHY.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHY == null || this.aHY == null) {
            return 0;
        }
        int size = 0 + this.aHY.size();
        if (this.aHX) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aHY.size()) {
            return null;
        }
        return this.aHY.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.aHY.size()) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) == -1 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.mListView = (ListView) viewGroup;
        switch (getItemViewType(i)) {
            case 0:
                return a(viewGroup, view, skinType);
            case 1:
                return a(i, view, skinType);
            default:
                return null;
        }
    }

    private View a(ViewGroup viewGroup, View view, int i) {
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.aHV.getPageContext().getPageActivity(), com.baidu.tieba.w.friend_feed_list_foot, viewGroup, false);
            u uVar = new u();
            uVar.moreLayout = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_more);
            uVar.moreTitleText = (TextView) view.findViewById(com.baidu.tieba.v.more_title);
            uVar.moreProgress = (ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress);
            view.setTag(uVar);
        }
        view.setOnClickListener(this.aIe);
        u uVar2 = (u) view.getTag();
        if (this.aHW) {
            uVar2.moreProgress.setVisibility(8);
            uVar2.moreTitleText.setText(com.baidu.tieba.y.click_load_more);
        } else {
            uVar2.moreProgress.setVisibility(8);
            uVar2.moreTitleText.setText(com.baidu.tieba.y.friendfeed_list_no_more);
        }
        n(view, i);
        return view;
    }

    private void n(View view, int i) {
        this.aHV.getLayoutMode().X(i == 1);
        this.aHV.getLayoutMode().h(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x03fa: INVOKE  (r2v13 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x03f6: INVOKE  (r2v12 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.friendFeed.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.friendFeed.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        x xVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.aHV.getPageContext().getPageActivity(), com.baidu.tieba.w.friendfeed_item, null);
            x xVar2 = new x(this, null);
            xVar2.aIi = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
            xVar2.aIz = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
            xVar2.aIj = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
            xVar2.aIq = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
            xVar2.aIp = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
            xVar2.aIo = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
            xVar2.aIn = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
            xVar2.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
            xVar2.aIk = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
            xVar2.aIl = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
            xVar2.aIm = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
            xVar2.aIr = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_praise_btn);
            xVar2.aIs = (ImageView) view.findViewById(com.baidu.tieba.v.frs_praise_icon);
            xVar2.aIt = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
            xVar2.aIu = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_reply_btn);
            xVar2.aIv = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
            xVar2.aIw = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
            xVar2.aIx = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
            xVar2.aIy = view.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
            xVar2.aIA = (LinearLayout) view.findViewById(com.baidu.tieba.v.live_card_layout);
            xVar2.aIB = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.item_card);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        ba.i(xVar.aIj, com.baidu.tieba.u.frs_item_control_btn_bg);
        ba.i((View) xVar.aIx, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        xVar.aIr.setOnClickListener(this);
        com.baidu.adp.lib.util.n.a(this.aHV.getPageContext().getPageActivity(), xVar.aIr, 0, 10, 0, 20);
        xVar.aIu.setOnClickListener(this);
        com.baidu.adp.lib.util.n.a(this.aHV.getPageContext().getPageActivity(), xVar.aIu, 0, 10, 0, 20);
        xVar.aIx.setOnClickListener(this);
        xVar.aIr.setOnTouchListener(new w(this, null));
        xVar.aIu.setTag(Integer.valueOf(i));
        xVar.aIr.setTag(Integer.valueOf(i));
        xVar.aIx.setTag(Integer.valueOf(i));
        this.aHV.getLayoutMode().X(i2 == 1);
        this.aHV.getLayoutMode().h(view);
        if (i == 0) {
            ba.i(xVar.aIi, com.baidu.tieba.u.bg_frs);
        } else {
            ba.j(xVar.aIi, com.baidu.tieba.s.cp_bg_line_c);
        }
        xVar.aIi.setPadding(0, i == 0 ? this.aIb : this.aIc, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        xVar.aIn.setText(bd.n(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.n.px().pz()) {
            xVar.aIq.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            xVar.aIq.setUserId(friendFeedThreadData.getAuthor().getUserId());
            xVar.aIq.setImageDrawable(null);
            xVar.aIq.c(portrait, 12, false);
        } else {
            xVar.aIq.setVisibility(8);
        }
        xVar.aIz.setOnClickListener(new r(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.aIa = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.aIa != null && this.aIa.size() > 0) {
            xVar.aIp.setVisibility(0);
            ba.b(xVar.aIo, com.baidu.tieba.s.cp_cont_h, 1);
            xVar.aIp.a(this.aIa, 2, this.aHV.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.aHV.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.aHV.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            xVar.aIp.setVisibility(8);
            ba.b(xVar.aIo, com.baidu.tieba.s.cp_cont_c, 1);
        }
        xVar.aIo.setText(friendFeedThreadData.getAuthor().getUserName());
        xVar.aIm.setVisibility(0);
        xVar.aIk.setVisibility(0);
        friendFeedThreadData.parser_title();
        xVar.mTitle.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iR(friendFeedThreadData.getId())) {
            ba.b(xVar.mTitle, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (friendFeedThreadData.getIs_ntitle() == 1) {
            xVar.mTitle.setVisibility(8);
        } else {
            xVar.mTitle.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (friendFeedThreadData.getAbstract_text() != null && friendFeedThreadData.getAbstract_text().trim().length() > 0) {
            stringBuffer.append(friendFeedThreadData.getAbstract_text());
        }
        ArrayList<MediaData> medias = friendFeedThreadData.getMedias();
        if (medias != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= medias.size()) {
                    break;
                }
                if (medias.get(i4).getVideoUrl() != null && medias.get(i4).getVideoUrl().endsWith("swf")) {
                    stringBuffer2.append(medias.get(i4).getVideoUrl());
                }
                i3 = i4 + 1;
            }
            stringBuffer.append(stringBuffer2.toString());
            if (stringBuffer.length() > 0) {
                if (stringBuffer.length() > 170) {
                    xVar.aIx.setVisibility(0);
                    xVar.aIk.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    xVar.aIx.setVisibility(8);
                    xVar.aIk.setText(stringBuffer.toString());
                }
            } else {
                xVar.aIx.setVisibility(8);
                xVar.aIk.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.n.px().pB()) {
            if (medias != null) {
                if (medias.size() > 0) {
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        int i8 = i5;
                        if (i8 >= medias.size()) {
                            break;
                        }
                        if (medias.get(i8) != null && (medias.get(i8).getType() == 3 || medias.get(i8).getType() == 5)) {
                            i6++;
                            i7++;
                        }
                        i5 = i8 + 1;
                    }
                    if (i6 > 0) {
                        MediaData[] mediaDataArr = new MediaData[i6];
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            int i11 = i9;
                            int i12 = i10;
                            if (i11 >= medias.size() || i12 >= i6) {
                                break;
                            }
                            if (medias.get(i11).getType() == 3 || medias.get(i11).getType() == 5) {
                                mediaDataArr[i12] = medias.get(i11);
                                i10 = i12 + 1;
                            } else {
                                i10 = i12;
                            }
                            i9 = i11 + 1;
                        }
                        xVar.aIm.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        xVar.aIm.setShowBig(this.aHZ);
                        xVar.aIm.setDrawNum(true);
                        xVar.aIm.setFromCDN(true);
                        xVar.aIm.a(this.aHV.getPageContext(), mediaDataArr, i7);
                        xVar.aIm.setImageFrom("other");
                    }
                } else {
                    xVar.aIm.setVisibility(8);
                }
            }
        } else {
            xVar.aIm.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            xVar.aIl.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            xVar.aIl.setVoiceModel(voiceModel);
            xVar.aIl.setTag(voiceModel);
            xVar.aIl.acc();
        } else {
            xVar.aIl.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                xVar.aIw.setVisibility(0);
                xVar.aIw.setIsFromPb(false);
                xVar.aIw.cu(i2);
                xVar.aIy.setVisibility(0);
                xVar.aIw.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                xVar.aIw.setVisibility(8);
                xVar.aIy.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                ba.c(xVar.aIs, com.baidu.tieba.u.icon_hand_click);
            } else {
                ba.c(xVar.aIs, com.baidu.tieba.u.icon_hand_frs_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                xVar.aIt.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                xVar.aIt.setText("999999+");
            }
        } else {
            xVar.aIy.setVisibility(8);
            xVar.aIw.setVisibility(8);
            xVar.aIt.setText(this.aHV.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            ba.c(xVar.aIs, com.baidu.tieba.u.icon_hand_frs_normal);
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                xVar.aIv.setText(String.valueOf(reply_num));
            } else {
                xVar.aIv.setText(this.aHV.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            xVar.aIv.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            xVar.aIm.setVisibility(8);
            xVar.aIA.setVisibility(0);
            LiveCardData liveCardData = new LiveCardData();
            liveCardData.setPublisherId(friendFeedThreadData.getAnchorInfoData().getAuthorId());
            liveCardData.setPublisherName(friendFeedThreadData.getAnchorInfoData().getAuthorName());
            liveCardData.setPublisherPortrait(friendFeedThreadData.getAnchorInfoData().getPublisherPortrait());
            liveCardData.setGroupId(friendFeedThreadData.getAnchorInfoData().getGroup_id());
            liveCardData.setIntro(friendFeedThreadData.getAnchorInfoData().getIntro());
            liveCardData.setLikers(friendFeedThreadData.getAnchorInfoData().getLikers());
            liveCardData.setListeners(friendFeedThreadData.getAnchorInfoData().getListeners());
            liveCardData.setName(friendFeedThreadData.getAnchorInfoData().getName());
            liveCardData.setPortrait(friendFeedThreadData.getAnchorInfoData().getPortrait());
            liveCardData.setStatus(friendFeedThreadData.getAnchorInfoData().getStatus());
            liveCardData.setStartTime(friendFeedThreadData.getAnchorInfoData().getStartTime());
            xVar.aIB.setData(liveCardData);
            xVar.aIB.setStatisticsKey("notice_frs_live");
        } else {
            xVar.aIA.setVisibility(8);
        }
        return view;
    }

    public void a(v vVar) {
        this.aIf = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aIf != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == Jb()) {
                if (this.isPraiseToServer) {
                    this.aIf.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
                com.baidu.tbadk.core.k.A(this.aHV.getPageContext().getPageActivity(), "all_live_read");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.aHV.getPageContext().getPageActivity(), friendFeedThreadData.getFid(), false)));
            } else {
                this.aIf.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int Jb() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int Jc() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int Jd() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    public void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aHV.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new s(this), 200L);
        }
    }

    public void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aHV.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new t(this), 600L);
        }
    }

    public void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.aHV.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale1));
    }

    public void bJ(boolean z) {
        this.aId = z;
    }
}
