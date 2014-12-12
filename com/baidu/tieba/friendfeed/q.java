package com.baidu.tieba.friendfeed;

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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements View.OnClickListener {
    private final FriendFeedActivity aAV;
    private boolean aAW;
    private boolean aAX;
    private boolean aAZ;
    private final int aBb;
    private final int aBc;
    private v aBd;
    private ListView mListView;
    private boolean mIsFromCDN = false;
    private ArrayList<IconData> aBa = null;
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private ArrayList<FriendFeedThreadData> aAY = new ArrayList<>();

    public q(FriendFeedActivity friendFeedActivity, int i, boolean z) {
        this.aAZ = false;
        this.aAV = friendFeedActivity;
        this.aAZ = z;
        bA(z);
        this.aBb = this.aAV.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
        this.aBc = this.aAV.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_divider_height);
    }

    public void bA(boolean z) {
        if (this.aAZ != z) {
            this.aAZ = z;
        }
    }

    public void a(com.baidu.tieba.data.i iVar) {
        this.aAY.addAll(iVar.Ct());
    }

    public ArrayList<FriendFeedThreadData> Fb() {
        return this.aAY;
    }

    public void reset(boolean z) {
        if (z) {
            this.aAY.clear();
            this.aAX = false;
            return;
        }
        this.aAX = true;
    }

    public void bB(boolean z) {
        this.aAX = z;
    }

    public boolean Fc() {
        return this.aAW;
    }

    public void bC(boolean z) {
        this.aAW = z;
    }

    public String Fd() {
        return this.aAY.size() > 0 ? this.aAY.get(this.aAY.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAY == null || this.aAY == null) {
            return 0;
        }
        int size = 0 + this.aAY.size();
        if (this.aAX) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aAY.size()) {
            return null;
        }
        return this.aAY.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.aAY.size()) {
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
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
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
            view = com.baidu.adp.lib.g.b.ek().a(this.aAV.getPageContext().getPageActivity(), com.baidu.tieba.x.friend_feed_list_foot, viewGroup, false);
            u uVar = new u();
            uVar.moreLayout = (LinearLayout) view.findViewById(com.baidu.tieba.w.list_more);
            uVar.moreTitleText = (TextView) view.findViewById(com.baidu.tieba.w.more_title);
            uVar.moreProgress = (ProgressBar) view.findViewById(com.baidu.tieba.w.more_progress);
            view.setTag(uVar);
        }
        u uVar2 = (u) view.getTag();
        if (this.aAW) {
            uVar2.moreProgress.setVisibility(0);
            uVar2.moreTitleText.setText(com.baidu.tieba.z.friendfeed_list_more);
        } else {
            uVar2.moreProgress.setVisibility(8);
            uVar2.moreTitleText.setText(com.baidu.tieba.z.friendfeed_list_no_more);
        }
        n(view, i);
        return view;
    }

    private void n(View view, int i) {
        this.aAV.getLayoutMode().ab(i == 1);
        this.aAV.getLayoutMode().h(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x03fa: INVOKE  (r2v13 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x03f6: INVOKE  (r2v12 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        x xVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.aAV.getPageContext().getPageActivity(), com.baidu.tieba.x.frs_item, null);
            x xVar2 = new x(this, null);
            xVar2.aBg = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_list);
            xVar2.aBx = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_item_user_info_view);
            xVar2.aBh = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_list_item_top_linear_layout);
            xVar2.aBo = (HeadImageView) view.findViewById(com.baidu.tieba.w.frs_photo);
            xVar2.aBn = (UserIconBox) view.findViewById(com.baidu.tieba.w.frs_user_tshow_icon_box);
            xVar2.aBm = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_author);
            xVar2.aBl = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_reply_time);
            xVar2.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_title);
            xVar2.aBi = (TextView) view.findViewById(com.baidu.tieba.w.abstract_text);
            xVar2.aBj = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.w.abstract_voice);
            xVar2.aBk = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.w.abstract_img_layout);
            xVar2.aBp = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_praise_btn);
            xVar2.aBq = (ImageView) view.findViewById(com.baidu.tieba.w.frs_praise_icon);
            xVar2.aBr = (TextView) view.findViewById(com.baidu.tieba.w.frs_praise_num);
            xVar2.aBs = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_reply_btn);
            xVar2.aBt = (TextView) view.findViewById(com.baidu.tieba.w.frs_reply_num);
            xVar2.aBu = (FrsPraiseView) view.findViewById(com.baidu.tieba.w.frs_praise_list_user_icon);
            xVar2.aBv = (TextView) view.findViewById(com.baidu.tieba.w.frs_more_abstract);
            xVar2.aBw = view.findViewById(com.baidu.tieba.w.frs_item_praise_divider_line);
            xVar2.aBy = (LinearLayout) view.findViewById(com.baidu.tieba.w.live_card_layout);
            xVar2.aBz = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.w.item_card);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        ax.i(xVar.aBh, com.baidu.tieba.v.frs_item_control_btn_bg);
        ax.i((View) xVar.aBv, com.baidu.tieba.v.frs_item_abstract_more_text_bg);
        xVar.aBp.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.aAV.getPageContext().getPageActivity(), xVar.aBp, 0, 10, 0, 20);
        xVar.aBs.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.aAV.getPageContext().getPageActivity(), xVar.aBs, 0, 10, 0, 20);
        xVar.aBv.setOnClickListener(this);
        xVar.aBp.setOnTouchListener(new w(this, null));
        xVar.aBs.setTag(Integer.valueOf(i));
        xVar.aBp.setTag(Integer.valueOf(i));
        xVar.aBv.setTag(Integer.valueOf(i));
        this.aAV.getLayoutMode().ab(i2 == 1);
        this.aAV.getLayoutMode().h(view);
        if (i == 0) {
            ax.i(xVar.aBg, com.baidu.tieba.v.bg_frs);
        } else {
            ax.j(xVar.aBg, com.baidu.tieba.t.cp_bg_line_c);
        }
        xVar.aBg.setPadding(0, i == 0 ? this.aBb : this.aBc, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        xVar.aBl.setText(ba.n(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.mc().me()) {
            xVar.aBo.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            xVar.aBo.setUserId(friendFeedThreadData.getAuthor().getUserId());
            xVar.aBo.setImageDrawable(null);
            xVar.aBo.d(portrait, 12, false);
        } else {
            xVar.aBo.setVisibility(8);
        }
        xVar.aBx.setOnClickListener(new r(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.aBa = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.aBa != null && this.aBa.size() > 0) {
            xVar.aBn.setVisibility(0);
            ax.b(xVar.aBm, com.baidu.tieba.t.cp_cont_h, 1);
            xVar.aBn.a(this.aBa, 2, this.aAV.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.aAV.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.aAV.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
        } else {
            xVar.aBn.setVisibility(8);
            ax.b(xVar.aBm, com.baidu.tieba.t.cp_cont_c, 1);
        }
        xVar.aBm.setText(friendFeedThreadData.getAuthor().getUserName());
        xVar.aBk.setVisibility(0);
        xVar.aBi.setVisibility(0);
        friendFeedThreadData.parser_title();
        xVar.mTitle.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.ip(friendFeedThreadData.getId())) {
            ax.b(xVar.mTitle, com.baidu.tieba.t.listview_item_thread_read, 1);
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
                    xVar.aBv.setVisibility(0);
                    xVar.aBi.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    xVar.aBv.setVisibility(8);
                    xVar.aBi.setText(stringBuffer.toString());
                }
            } else {
                xVar.aBv.setVisibility(8);
                xVar.aBi.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.mc().mg()) {
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
                        xVar.aBk.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        xVar.aBk.setShowBig(this.aAZ);
                        xVar.aBk.setDrawNum(true);
                        xVar.aBk.setFromCDN(true);
                        xVar.aBk.a(this.aAV.getPageContext(), mediaDataArr, i7);
                        xVar.aBk.setImageFrom("other");
                    }
                } else {
                    xVar.aBk.setVisibility(8);
                }
            }
        } else {
            xVar.aBk.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            xVar.aBj.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            xVar.aBj.setVoiceModel(voiceModel);
            xVar.aBj.setTag(voiceModel);
            xVar.aBj.Zf();
        } else {
            xVar.aBj.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                xVar.aBu.setVisibility(0);
                xVar.aBu.setIsFromPb(false);
                xVar.aBu.cm(i2);
                xVar.aBw.setVisibility(0);
                xVar.aBu.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                xVar.aBu.setVisibility(8);
                xVar.aBw.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                ax.c(xVar.aBq, com.baidu.tieba.v.icon_hand_click);
            } else {
                ax.c(xVar.aBq, com.baidu.tieba.v.icon_hand_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                xVar.aBr.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                xVar.aBr.setText("999999+");
            }
        } else {
            xVar.aBw.setVisibility(8);
            xVar.aBu.setVisibility(8);
            xVar.aBr.setText(this.aAV.getResources().getString(com.baidu.tieba.z.frs_item_praise_text));
            ax.c(xVar.aBq, com.baidu.tieba.v.icon_hand_normal);
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                xVar.aBt.setText(String.valueOf(reply_num));
            } else {
                xVar.aBt.setText(this.aAV.getResources().getString(com.baidu.tieba.z.frs_item_reply_text));
            }
        } else {
            xVar.aBt.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            xVar.aBk.setVisibility(8);
            xVar.aBy.setVisibility(0);
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
            xVar.aBz.setData(liveCardData);
            xVar.aBz.setStatisticsKey("notice_frs_live");
        } else {
            xVar.aBy.setVisibility(8);
        }
        return view;
    }

    public void a(v vVar) {
        this.aBd = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBd != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == Fe()) {
                if (this.isPraiseToServer) {
                    this.aBd.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.w.frs_live_upItem) {
                com.baidu.tbadk.core.i.B(this.aAV.getPageContext().getPageActivity(), "all_live_read");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.aAV.getPageContext().getPageActivity(), friendFeedThreadData.getFid(), false)));
            } else {
                this.aBd.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int Fe() {
        return com.baidu.tieba.w.frs_praise_btn;
    }

    public int Ff() {
        return com.baidu.tieba.w.frs_reply_btn;
    }

    public int Fg() {
        return com.baidu.tieba.w.frs_more_abstract;
    }

    public void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aAV.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale2));
            new Handler().postDelayed(new s(this), 200L);
        }
    }

    public void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aAV.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale3));
            new Handler().postDelayed(new t(this), 600L);
        }
    }

    public void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.aAV.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale1));
    }
}
