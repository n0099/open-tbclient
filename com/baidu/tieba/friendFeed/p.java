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
    private final FriendFeedActivity aHN;
    private boolean aHO;
    private boolean aHP;
    private boolean aHR;
    private final int aHT;
    private final int aHU;
    private boolean aHV;
    private v aHX;
    private ListView mListView;
    private boolean mIsFromCDN = false;
    private ArrayList<IconData> aHS = null;
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private View.OnClickListener aHW = new q(this);
    private ArrayList<FriendFeedThreadData> aHQ = new ArrayList<>();

    public p(FriendFeedActivity friendFeedActivity, int i, boolean z) {
        this.aHR = false;
        this.aHN = friendFeedActivity;
        this.aHR = z;
        bG(z);
        this.aHT = this.aHN.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.aHU = this.aHN.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
    }

    public void bG(boolean z) {
        if (this.aHR != z) {
            this.aHR = z;
        }
    }

    public void a(com.baidu.tieba.friendFeed.data.a aVar) {
        this.aHQ.addAll(aVar.Ji());
    }

    public ArrayList<FriendFeedThreadData> IS() {
        return this.aHQ;
    }

    public void reset(boolean z) {
        if (z) {
            this.aHQ.clear();
            this.aHP = false;
            return;
        }
        this.aHP = true;
    }

    public void bH(boolean z) {
        this.aHP = z;
    }

    public boolean IT() {
        return this.aHO;
    }

    public void bI(boolean z) {
        this.aHO = z;
    }

    public String IU() {
        return this.aHQ.size() > 0 ? this.aHQ.get(this.aHQ.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHQ == null || this.aHQ == null) {
            return 0;
        }
        int size = 0 + this.aHQ.size();
        if (this.aHP) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aHQ.size()) {
            return null;
        }
        return this.aHQ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.aHQ.size()) {
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
            view = com.baidu.adp.lib.g.b.hH().a(this.aHN.getPageContext().getPageActivity(), com.baidu.tieba.w.friend_feed_list_foot, viewGroup, false);
            u uVar = new u();
            uVar.moreLayout = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_more);
            uVar.moreTitleText = (TextView) view.findViewById(com.baidu.tieba.v.more_title);
            uVar.moreProgress = (ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress);
            view.setTag(uVar);
        }
        view.setOnClickListener(this.aHW);
        u uVar2 = (u) view.getTag();
        if (this.aHO) {
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
        this.aHN.getLayoutMode().X(i == 1);
        this.aHN.getLayoutMode().h(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x03fa: INVOKE  (r2v13 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x03f6: INVOKE  (r2v12 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.friendFeed.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.friendFeed.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        x xVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.aHN.getPageContext().getPageActivity(), com.baidu.tieba.w.friendfeed_item, null);
            x xVar2 = new x(this, null);
            xVar2.aIa = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
            xVar2.aIr = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
            xVar2.aIb = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
            xVar2.aIi = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
            xVar2.aIh = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
            xVar2.aIg = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
            xVar2.aIf = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
            xVar2.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
            xVar2.aIc = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
            xVar2.aId = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
            xVar2.aIe = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
            xVar2.aIj = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_praise_btn);
            xVar2.aIk = (ImageView) view.findViewById(com.baidu.tieba.v.frs_praise_icon);
            xVar2.aIl = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
            xVar2.aIm = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_reply_btn);
            xVar2.aIn = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
            xVar2.aIo = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
            xVar2.aIp = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
            xVar2.aIq = view.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
            xVar2.aIs = (LinearLayout) view.findViewById(com.baidu.tieba.v.live_card_layout);
            xVar2.aIt = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.item_card);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        ba.i(xVar.aIb, com.baidu.tieba.u.frs_item_control_btn_bg);
        ba.i((View) xVar.aIp, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        xVar.aIj.setOnClickListener(this);
        com.baidu.adp.lib.util.n.a(this.aHN.getPageContext().getPageActivity(), xVar.aIj, 0, 10, 0, 20);
        xVar.aIm.setOnClickListener(this);
        com.baidu.adp.lib.util.n.a(this.aHN.getPageContext().getPageActivity(), xVar.aIm, 0, 10, 0, 20);
        xVar.aIp.setOnClickListener(this);
        xVar.aIj.setOnTouchListener(new w(this, null));
        xVar.aIm.setTag(Integer.valueOf(i));
        xVar.aIj.setTag(Integer.valueOf(i));
        xVar.aIp.setTag(Integer.valueOf(i));
        this.aHN.getLayoutMode().X(i2 == 1);
        this.aHN.getLayoutMode().h(view);
        if (i == 0) {
            ba.i(xVar.aIa, com.baidu.tieba.u.bg_frs);
        } else {
            ba.j(xVar.aIa, com.baidu.tieba.s.cp_bg_line_c);
        }
        xVar.aIa.setPadding(0, i == 0 ? this.aHT : this.aHU, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        xVar.aIf.setText(bd.n(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.n.px().pz()) {
            xVar.aIi.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            xVar.aIi.setUserId(friendFeedThreadData.getAuthor().getUserId());
            xVar.aIi.setImageDrawable(null);
            xVar.aIi.c(portrait, 12, false);
        } else {
            xVar.aIi.setVisibility(8);
        }
        xVar.aIr.setOnClickListener(new r(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.aHS = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.aHS != null && this.aHS.size() > 0) {
            xVar.aIh.setVisibility(0);
            ba.b(xVar.aIg, com.baidu.tieba.s.cp_cont_h, 1);
            xVar.aIh.a(this.aHS, 2, this.aHN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.aHN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.aHN.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            xVar.aIh.setVisibility(8);
            ba.b(xVar.aIg, com.baidu.tieba.s.cp_cont_c, 1);
        }
        xVar.aIg.setText(friendFeedThreadData.getAuthor().getUserName());
        xVar.aIe.setVisibility(0);
        xVar.aIc.setVisibility(0);
        friendFeedThreadData.parser_title();
        xVar.mTitle.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iO(friendFeedThreadData.getId())) {
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
                    xVar.aIp.setVisibility(0);
                    xVar.aIc.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    xVar.aIp.setVisibility(8);
                    xVar.aIc.setText(stringBuffer.toString());
                }
            } else {
                xVar.aIp.setVisibility(8);
                xVar.aIc.setVisibility(8);
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
                        xVar.aIe.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        xVar.aIe.setShowBig(this.aHR);
                        xVar.aIe.setDrawNum(true);
                        xVar.aIe.setFromCDN(true);
                        xVar.aIe.a(this.aHN.getPageContext(), mediaDataArr, i7);
                        xVar.aIe.setImageFrom("other");
                    }
                } else {
                    xVar.aIe.setVisibility(8);
                }
            }
        } else {
            xVar.aIe.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            xVar.aId.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            xVar.aId.setVoiceModel(voiceModel);
            xVar.aId.setTag(voiceModel);
            xVar.aId.abN();
        } else {
            xVar.aId.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.n.px().pz()) {
                xVar.aIo.setVisibility(0);
                xVar.aIo.setIsFromPb(false);
                xVar.aIo.cu(i2);
                xVar.aIq.setVisibility(0);
                xVar.aIo.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                xVar.aIo.setVisibility(8);
                xVar.aIq.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                ba.c(xVar.aIk, com.baidu.tieba.u.icon_hand_click);
            } else {
                ba.c(xVar.aIk, com.baidu.tieba.u.icon_hand_frs_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                xVar.aIl.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                xVar.aIl.setText("999999+");
            }
        } else {
            xVar.aIq.setVisibility(8);
            xVar.aIo.setVisibility(8);
            xVar.aIl.setText(this.aHN.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            ba.c(xVar.aIk, com.baidu.tieba.u.icon_hand_frs_normal);
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                xVar.aIn.setText(String.valueOf(reply_num));
            } else {
                xVar.aIn.setText(this.aHN.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            xVar.aIn.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            xVar.aIe.setVisibility(8);
            xVar.aIs.setVisibility(0);
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
            xVar.aIt.setData(liveCardData);
            xVar.aIt.setStatisticsKey("notice_frs_live");
        } else {
            xVar.aIs.setVisibility(8);
        }
        return view;
    }

    public void a(v vVar) {
        this.aHX = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aHX != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == IV()) {
                if (this.isPraiseToServer) {
                    this.aHX.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
                com.baidu.tbadk.core.k.A(this.aHN.getPageContext().getPageActivity(), "all_live_read");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.aHN.getPageContext().getPageActivity(), friendFeedThreadData.getFid(), false)));
            } else {
                this.aHX.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int IV() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int IW() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int IX() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    public void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aHN.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new s(this), 200L);
        }
    }

    public void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aHN.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new t(this), 600L);
        }
    }

    public void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.aHN.getPageContext().getPageActivity(), com.baidu.tieba.p.praise_animation_scale1));
    }

    public void bJ(boolean z) {
        this.aHV = z;
    }
}
