package com.baidu.tieba.friendfeed;

import android.content.Context;
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
import com.baidu.tbadk.core.atomData.BackupFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends BaseAdapter implements View.OnClickListener {
    private boolean ayV;
    private boolean ayW;
    private boolean ayY;
    private final int aza;
    private final int azb;
    private ListView aze;
    private v azf;
    private final Context mContext;
    private boolean mIsFromCDN = false;
    private ArrayList<IconData> ayZ = null;
    private long azc = 0;
    private boolean azd = true;
    private ArrayList<FriendFeedThreadData> ayX = new ArrayList<>();

    public q(Context context, int i, boolean z) {
        this.ayY = false;
        this.mContext = context;
        this.ayY = z;
        bL(z);
        this.aza = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
        this.azb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_divider_height);
    }

    public void bL(boolean z) {
        if (this.ayY != z) {
            this.ayY = z;
        }
    }

    public void a(com.baidu.tieba.data.s sVar) {
        this.ayX.addAll(sVar.zh());
    }

    public ArrayList<FriendFeedThreadData> EK() {
        return this.ayX;
    }

    public void bM(boolean z) {
        if (z) {
            this.ayX.clear();
            this.ayW = false;
            return;
        }
        this.ayW = true;
    }

    public void bN(boolean z) {
        this.ayW = z;
    }

    public boolean EL() {
        return this.ayV;
    }

    public void bO(boolean z) {
        this.ayV = z;
    }

    public String EM() {
        return this.ayX.size() > 0 ? this.ayX.get(this.ayX.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ayX == null || this.ayX == null) {
            return 0;
        }
        int size = 0 + this.ayX.size();
        if (this.ayW) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.ayX.size()) {
            return null;
        }
        return this.ayX.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.ayX.size()) {
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
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.aze = (ListView) viewGroup;
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
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.w.friend_feed_list_foot, viewGroup, false);
            u uVar = new u();
            uVar.azi = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_more);
            uVar.azj = (TextView) view.findViewById(com.baidu.tieba.v.more_title);
            uVar.azk = (ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress);
            view.setTag(uVar);
        }
        u uVar2 = (u) view.getTag();
        if (this.ayV) {
            uVar2.azi.setVisibility(0);
            uVar2.azj.setText(com.baidu.tieba.y.friendfeed_list_more);
        } else {
            uVar2.azi.setVisibility(8);
        }
        m(view, i);
        return view;
    }

    private void m(View view, int i) {
        ((FriendFeedActivity) this.mContext).getLayoutMode().L(i == 1);
        ((FriendFeedActivity) this.mContext).getLayoutMode().h(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x03da: INVOKE  (r2v12 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x03d6: INVOKE  (r2v11 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        x xVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item, null);
            x xVar2 = new x(this, null);
            xVar2.azl = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list);
            xVar2.azC = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_item_user_info_view);
            xVar2.azm = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_list_item_top_linear_layout);
            xVar2.azt = (HeadImageView) view.findViewById(com.baidu.tieba.v.frs_photo);
            xVar2.azs = (UserIconBox) view.findViewById(com.baidu.tieba.v.frs_user_tshow_icon_box);
            xVar2.azr = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_author);
            xVar2.azq = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_reply_time);
            xVar2.JN = (TextView) view.findViewById(com.baidu.tieba.v.frs_lv_title);
            xVar2.azn = (TextView) view.findViewById(com.baidu.tieba.v.abstract_text);
            xVar2.azo = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
            xVar2.azp = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
            xVar2.azu = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_praise_btn);
            xVar2.azv = (ImageView) view.findViewById(com.baidu.tieba.v.frs_praise_icon);
            xVar2.azw = (TextView) view.findViewById(com.baidu.tieba.v.frs_praise_num);
            xVar2.azx = (LinearLayout) view.findViewById(com.baidu.tieba.v.frs_reply_btn);
            xVar2.azy = (TextView) view.findViewById(com.baidu.tieba.v.frs_reply_num);
            xVar2.azz = (FrsPraiseView) view.findViewById(com.baidu.tieba.v.frs_praise_list_user_icon);
            xVar2.azA = (TextView) view.findViewById(com.baidu.tieba.v.frs_more_abstract);
            xVar2.azB = view.findViewById(com.baidu.tieba.v.frs_item_praise_divider_line);
            xVar2.azD = (LinearLayout) view.findViewById(com.baidu.tieba.v.live_card_layout);
            xVar2.azE = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.v.item_card);
            view.setTag(xVar2);
            xVar = xVar2;
        } else {
            xVar = (x) view.getTag();
        }
        aw.h(xVar.azm, com.baidu.tieba.u.frs_item_control_btn_bg);
        aw.h((View) xVar.azA, com.baidu.tieba.u.frs_item_abstract_more_text_bg);
        xVar.azu.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, xVar.azu, 0, 10, 0, 20);
        xVar.azx.setOnClickListener(this);
        com.baidu.adp.lib.util.m.a(this.mContext, xVar.azx, 0, 10, 0, 20);
        xVar.azA.setOnClickListener(this);
        xVar.azu.setOnTouchListener(new w(this, null));
        xVar.azx.setTag(Integer.valueOf(i));
        xVar.azu.setTag(Integer.valueOf(i));
        xVar.azA.setTag(Integer.valueOf(i));
        ((FriendFeedActivity) this.mContext).getLayoutMode().L(i2 == 1);
        ((FriendFeedActivity) this.mContext).getLayoutMode().h(view);
        if (i == 0) {
            aw.h(xVar.azl, com.baidu.tieba.u.bg_frs);
        } else {
            aw.i(xVar.azl, com.baidu.tieba.s.cp_bg_line_c);
        }
        xVar.azl.setPadding(0, i == 0 ? this.aza : this.azb, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        xVar.azq.setText(az.j(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.l.js().ju()) {
            xVar.azt.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            xVar.azt.setUserId(friendFeedThreadData.getAuthor().getUserId());
            xVar.azt.setImageDrawable(null);
            xVar.azt.c(portrait, 12, false);
        } else {
            xVar.azt.setVisibility(8);
        }
        xVar.azC.setOnClickListener(new r(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.ayZ = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.ayZ != null && this.ayZ.size() > 0) {
            xVar.azs.setVisibility(0);
            aw.b(xVar.azr, com.baidu.tieba.s.cp_cont_h, 1);
            xVar.azs.a(this.ayZ, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.small_icon_margin));
        } else {
            xVar.azs.setVisibility(8);
            aw.b(xVar.azr, com.baidu.tieba.s.cp_cont_c, 1);
        }
        xVar.azr.setText(friendFeedThreadData.getAuthor().getUserName());
        xVar.azp.setVisibility(0);
        xVar.azn.setVisibility(0);
        friendFeedThreadData.parser_title();
        xVar.JN.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.util.o wL = aj.wm().wL();
        if (wL != null && wL.hH(friendFeedThreadData.getId())) {
            aw.b(xVar.JN, com.baidu.tieba.s.listview_item_thread_read, 1);
        }
        if (friendFeedThreadData.getIs_ntitle() == 1) {
            xVar.JN.setVisibility(8);
        } else {
            xVar.JN.setVisibility(0);
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
                    xVar.azA.setVisibility(0);
                    xVar.azn.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    xVar.azA.setVisibility(8);
                    xVar.azn.setText(stringBuffer.toString());
                }
            } else {
                xVar.azA.setVisibility(8);
                xVar.azn.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.l.js().jw()) {
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
                        xVar.azp.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        xVar.azp.setShowBig(this.ayY);
                        xVar.azp.setDrawNum(true);
                        xVar.azp.setFromCDN(true);
                        xVar.azp.a(mediaDataArr, i7);
                        xVar.azp.setImageFrom("other");
                    }
                } else {
                    xVar.azp.setVisibility(8);
                }
            }
        } else {
            xVar.azp.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            xVar.azo.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            xVar.azo.setVoiceModel(voiceModel);
            xVar.azo.setTag(voiceModel);
            xVar.azo.YL();
        } else {
            xVar.azo.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.l.js().ju()) {
                xVar.azz.setVisibility(0);
                xVar.azz.setIsFromPb(false);
                xVar.azz.bN(i2);
                xVar.azB.setVisibility(0);
                xVar.azz.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                xVar.azz.setVisibility(8);
                xVar.azB.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                aw.c(xVar.azv, com.baidu.tieba.u.icon_hand_click);
            } else {
                aw.c(xVar.azv, com.baidu.tieba.u.icon_hand_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                xVar.azw.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                xVar.azw.setText("999999+");
            }
        } else {
            xVar.azB.setVisibility(8);
            xVar.azz.setVisibility(8);
            xVar.azw.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_praise_text));
            aw.c(xVar.azv, com.baidu.tieba.u.icon_hand_normal);
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                xVar.azy.setText(String.valueOf(reply_num));
            } else {
                xVar.azy.setText(this.mContext.getResources().getString(com.baidu.tieba.y.frs_item_reply_text));
            }
        } else {
            xVar.azy.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            xVar.azp.setVisibility(8);
            xVar.azD.setVisibility(0);
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
            xVar.azE.setData(liveCardData);
            xVar.azE.setStatisticsKey("notice_frs_live");
        } else {
            xVar.azD.setVisibility(8);
        }
        return view;
    }

    public void a(v vVar) {
        this.azf = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.azf != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.aze.getChildAt(intValue - (this.aze.getFirstVisiblePosition() - this.aze.getHeaderViewsCount()));
            if (view.getId() == EN()) {
                if (this.azd) {
                    this.azf.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.v.frs_live_upItem) {
                com.baidu.tbadk.core.j.l(this.mContext, "all_live_read");
                if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsLiveListActivityConfig(this.mContext, friendFeedThreadData.getFid(), false)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BackupFrsLiveListActivityConfig(this.mContext, friendFeedThreadData.getFid(), false)));
                }
            } else {
                this.azf.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int EN() {
        return com.baidu.tieba.v.frs_praise_btn;
    }

    public int EO() {
        return com.baidu.tieba.v.frs_reply_btn;
    }

    public int EP() {
        return com.baidu.tieba.v.frs_more_abstract;
    }

    public void c(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new s(this), 200L);
        }
    }

    public void d(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new t(this), 600L);
        }
    }

    public void z(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.mContext, com.baidu.tieba.p.praise_animation_scale1));
    }
}
