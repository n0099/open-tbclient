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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private final FriendFeedActivity aBW;
    private boolean aBX;
    private boolean aBY;
    private boolean aCa;
    private final int aCc;
    private final int aCd;
    private u aCe;
    private ListView mListView;
    private boolean mIsFromCDN = false;
    private ArrayList<IconData> aCb = null;
    private long praiseStopTime = 0;
    private boolean isPraiseToServer = true;
    private ArrayList<FriendFeedThreadData> aBZ = new ArrayList<>();

    public p(FriendFeedActivity friendFeedActivity, int i, boolean z) {
        this.aCa = false;
        this.aBW = friendFeedActivity;
        this.aCa = z;
        bD(z);
        this.aCc = this.aBW.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
        this.aCd = this.aBW.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_divider_height);
    }

    public void bD(boolean z) {
        if (this.aCa != z) {
            this.aCa = z;
        }
    }

    public void a(com.baidu.tieba.data.i iVar) {
        this.aBZ.addAll(iVar.CS());
    }

    public ArrayList<FriendFeedThreadData> Fz() {
        return this.aBZ;
    }

    public void reset(boolean z) {
        if (z) {
            this.aBZ.clear();
            this.aBY = false;
            return;
        }
        this.aBY = true;
    }

    public void bE(boolean z) {
        this.aBY = z;
    }

    public boolean FA() {
        return this.aBX;
    }

    public void bF(boolean z) {
        this.aBX = z;
    }

    public String FB() {
        return this.aBZ.size() > 0 ? this.aBZ.get(this.aBZ.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aBZ == null || this.aBZ == null) {
            return 0;
        }
        int size = 0 + this.aBZ.size();
        if (this.aBY) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.aBZ.size()) {
            return null;
        }
        return this.aBZ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.aBZ.size()) {
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
            view = com.baidu.adp.lib.g.b.ei().a(this.aBW.getPageContext().getPageActivity(), com.baidu.tieba.x.friend_feed_list_foot, viewGroup, false);
            t tVar = new t();
            tVar.moreLayout = (LinearLayout) view.findViewById(com.baidu.tieba.w.list_more);
            tVar.moreTitleText = (TextView) view.findViewById(com.baidu.tieba.w.more_title);
            tVar.moreProgress = (ProgressBar) view.findViewById(com.baidu.tieba.w.more_progress);
            view.setTag(tVar);
        }
        t tVar2 = (t) view.getTag();
        if (this.aBX) {
            tVar2.moreProgress.setVisibility(0);
            tVar2.moreTitleText.setText(z.friendfeed_list_more);
        } else {
            tVar2.moreProgress.setVisibility(8);
            tVar2.moreTitleText.setText(z.friendfeed_list_no_more);
        }
        n(view, i);
        return view;
    }

    private void n(View view, int i) {
        this.aBW.getLayoutMode().ab(i == 1);
        this.aBW.getLayoutMode().h(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x03fa: INVOKE  (r2v13 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x03f6: INVOKE  (r2v12 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        w wVar;
        if (view == null || view.getTag() == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.aBW.getPageContext().getPageActivity(), com.baidu.tieba.x.friend_feed_item, null);
            w wVar2 = new w(this, null);
            wVar2.aCh = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_list);
            wVar2.aCy = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_item_user_info_view);
            wVar2.aCi = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_list_item_top_linear_layout);
            wVar2.aCp = (HeadImageView) view.findViewById(com.baidu.tieba.w.frs_photo);
            wVar2.aCo = (UserIconBox) view.findViewById(com.baidu.tieba.w.frs_user_tshow_icon_box);
            wVar2.aCn = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_author);
            wVar2.aCm = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_reply_time);
            wVar2.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.frs_lv_title);
            wVar2.aCj = (TextView) view.findViewById(com.baidu.tieba.w.abstract_text);
            wVar2.aCk = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.w.abstract_voice);
            wVar2.aCl = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.w.abstract_img_layout);
            wVar2.aCq = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_praise_btn);
            wVar2.aCr = (ImageView) view.findViewById(com.baidu.tieba.w.frs_praise_icon);
            wVar2.aCs = (TextView) view.findViewById(com.baidu.tieba.w.frs_praise_num);
            wVar2.aCt = (LinearLayout) view.findViewById(com.baidu.tieba.w.frs_reply_btn);
            wVar2.aCu = (TextView) view.findViewById(com.baidu.tieba.w.frs_reply_num);
            wVar2.aCv = (FrsPraiseView) view.findViewById(com.baidu.tieba.w.frs_praise_list_user_icon);
            wVar2.aCw = (TextView) view.findViewById(com.baidu.tieba.w.frs_more_abstract);
            wVar2.aCx = view.findViewById(com.baidu.tieba.w.frs_item_praise_divider_line);
            wVar2.aCz = (LinearLayout) view.findViewById(com.baidu.tieba.w.live_card_layout);
            wVar2.aCA = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.w.item_card);
            view.setTag(wVar2);
            wVar = wVar2;
        } else {
            wVar = (w) view.getTag();
        }
        bc.i(wVar.aCi, com.baidu.tieba.v.frs_item_control_btn_bg);
        bc.i((View) wVar.aCw, com.baidu.tieba.v.frs_item_abstract_more_text_bg);
        wVar.aCq.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.aBW.getPageContext().getPageActivity(), wVar.aCq, 0, 10, 0, 20);
        wVar.aCt.setOnClickListener(this);
        com.baidu.adp.lib.util.l.a(this.aBW.getPageContext().getPageActivity(), wVar.aCt, 0, 10, 0, 20);
        wVar.aCw.setOnClickListener(this);
        wVar.aCq.setOnTouchListener(new v(this, null));
        wVar.aCt.setTag(Integer.valueOf(i));
        wVar.aCq.setTag(Integer.valueOf(i));
        wVar.aCw.setTag(Integer.valueOf(i));
        this.aBW.getLayoutMode().ab(i2 == 1);
        this.aBW.getLayoutMode().h(view);
        if (i == 0) {
            bc.i(wVar.aCh, com.baidu.tieba.v.bg_frs);
        } else {
            bc.j(wVar.aCh, com.baidu.tieba.t.cp_bg_line_c);
        }
        wVar.aCh.setPadding(0, i == 0 ? this.aCc : this.aCd, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        wVar.aCm.setText(bf.n(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.mc().me()) {
            wVar.aCp.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            wVar.aCp.setUserId(friendFeedThreadData.getAuthor().getUserId());
            wVar.aCp.setImageDrawable(null);
            wVar.aCp.d(portrait, 12, false);
        } else {
            wVar.aCp.setVisibility(8);
        }
        wVar.aCy.setOnClickListener(new q(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.aCb = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.aCb != null && this.aCb.size() > 0) {
            wVar.aCo.setVisibility(0);
            bc.b(wVar.aCn, com.baidu.tieba.t.cp_cont_h, 1);
            wVar.aCo.a(this.aCb, 2, this.aBW.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_width), this.aBW.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_height), this.aBW.getResources().getDimensionPixelSize(com.baidu.tieba.u.small_icon_margin));
        } else {
            wVar.aCo.setVisibility(8);
            bc.b(wVar.aCn, com.baidu.tieba.t.cp_cont_c, 1);
        }
        wVar.aCn.setText(friendFeedThreadData.getAuthor().getUserName());
        wVar.aCl.setVisibility(0);
        wVar.aCj.setVisibility(0);
        friendFeedThreadData.parser_title();
        wVar.mTitle.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.tbadkCore.util.l readThreadHistory = TbadkApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.iw(friendFeedThreadData.getId())) {
            bc.b(wVar.mTitle, com.baidu.tieba.t.listview_item_thread_read, 1);
        }
        if (friendFeedThreadData.getIs_ntitle() == 1) {
            wVar.mTitle.setVisibility(8);
        } else {
            wVar.mTitle.setVisibility(0);
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
                    wVar.aCw.setVisibility(0);
                    wVar.aCj.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    wVar.aCw.setVisibility(8);
                    wVar.aCj.setText(stringBuffer.toString());
                }
            } else {
                wVar.aCw.setVisibility(8);
                wVar.aCj.setVisibility(8);
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
                        wVar.aCl.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        wVar.aCl.setShowBig(this.aCa);
                        wVar.aCl.setDrawNum(true);
                        wVar.aCl.setFromCDN(true);
                        wVar.aCl.a(this.aBW.getPageContext(), mediaDataArr, i7);
                        wVar.aCl.setImageFrom("other");
                    }
                } else {
                    wVar.aCl.setVisibility(8);
                }
            }
        } else {
            wVar.aCl.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            wVar.aCk.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            wVar.aCk.setVoiceModel(voiceModel);
            wVar.aCk.setTag(voiceModel);
            wVar.aCk.ZK();
        } else {
            wVar.aCk.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.mc().me()) {
                wVar.aCv.setVisibility(0);
                wVar.aCv.setIsFromPb(false);
                wVar.aCv.ct(i2);
                wVar.aCx.setVisibility(0);
                wVar.aCv.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                wVar.aCv.setVisibility(8);
                wVar.aCx.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                bc.c(wVar.aCr, com.baidu.tieba.v.icon_hand_click);
            } else {
                bc.c(wVar.aCr, com.baidu.tieba.v.icon_hand_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                wVar.aCs.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                wVar.aCs.setText("999999+");
            }
        } else {
            wVar.aCx.setVisibility(8);
            wVar.aCv.setVisibility(8);
            wVar.aCs.setText(this.aBW.getResources().getString(z.frs_item_praise_text));
            bc.c(wVar.aCr, com.baidu.tieba.v.icon_hand_normal);
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                wVar.aCu.setText(String.valueOf(reply_num));
            } else {
                wVar.aCu.setText(this.aBW.getResources().getString(z.frs_item_reply_text));
            }
        } else {
            wVar.aCu.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            wVar.aCl.setVisibility(8);
            wVar.aCz.setVisibility(0);
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
            wVar.aCA.setData(liveCardData);
            wVar.aCA.setStatisticsKey("notice_frs_live");
        } else {
            wVar.aCz.setVisibility(8);
        }
        return view;
    }

    public void a(u uVar) {
        this.aCe = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCe != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.mListView.getChildAt(intValue - (this.mListView.getFirstVisiblePosition() - this.mListView.getHeaderViewsCount()));
            if (view.getId() == FC()) {
                if (this.isPraiseToServer) {
                    this.aCe.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.w.frs_live_upItem) {
                com.baidu.tbadk.core.i.A(this.aBW.getPageContext().getPageActivity(), "all_live_read");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.aBW.getPageContext().getPageActivity(), friendFeedThreadData.getFid(), false)));
            } else {
                this.aCe.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int FC() {
        return com.baidu.tieba.w.frs_praise_btn;
    }

    public int FD() {
        return com.baidu.tieba.w.frs_reply_btn;
    }

    public int FE() {
        return com.baidu.tieba.w.frs_more_abstract;
    }

    public void praiseAnimCancel(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aBW.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale2));
            new Handler().postDelayed(new r(this), 200L);
        }
    }

    public void praiseAnimUp(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.aBW.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale3));
            new Handler().postDelayed(new s(this), 600L);
        }
    }

    public void praiseAnimDown(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.aBW.getPageContext().getPageActivity(), com.baidu.tieba.q.praise_animation_scale1));
    }
}
