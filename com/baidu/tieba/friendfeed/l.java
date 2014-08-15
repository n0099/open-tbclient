package com.baidu.tieba.friendfeed;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.view.FrsPraiseView;
import com.baidu.tieba.v;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l extends BaseAdapter implements View.OnClickListener {
    private final Context a;
    private boolean b;
    private boolean c;
    private boolean e;
    private final int h;
    private final int i;
    private ListView l;
    private q m;
    private boolean f = false;
    private LinkedList<IconData> g = null;
    private long j = 0;
    private boolean k = true;
    private ArrayList<FriendFeedThreadData> d = new ArrayList<>();

    public l(Context context, int i, boolean z) {
        this.e = false;
        this.a = context;
        this.e = z;
        a(z);
        this.h = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_item_margin);
        this.i = this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.listview_divider_height);
    }

    public void a(boolean z) {
        if (this.e != z) {
            this.e = z;
        }
    }

    public void a(com.baidu.tieba.data.s sVar) {
        this.d.addAll(sVar.b());
    }

    public ArrayList<FriendFeedThreadData> a() {
        return this.d;
    }

    public void b(boolean z) {
        if (z) {
            this.d.clear();
            this.c = false;
            return;
        }
        this.c = true;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public boolean b() {
        return this.b;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public String c() {
        return this.d.size() > 0 ? this.d.get(this.d.size() - 1).getTimeline() : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.d == null || this.d == null) {
            return 0;
        }
        int size = 0 + this.d.size();
        if (this.c) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.d.size()) {
            return null;
        }
        return this.d.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i < this.d.size()) {
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
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.l = (ListView) viewGroup;
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
            view = LayoutInflater.from(this.a).inflate(v.friend_feed_list_foot, viewGroup, false);
            p pVar = new p();
            pVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.list_more);
            pVar.b = (TextView) view.findViewById(com.baidu.tieba.u.more_title);
            pVar.c = (ProgressBar) view.findViewById(com.baidu.tieba.u.more_progress);
            view.setTag(pVar);
        }
        p pVar2 = (p) view.getTag();
        if (this.b) {
            pVar2.b.setText(x.friendfeed_list_more);
            pVar2.c.setVisibility(0);
        } else {
            pVar2.b.setText(x.no_more_to_load);
            pVar2.c.setVisibility(8);
        }
        a(view, i);
        return view;
    }

    private void a(View view, int i) {
        ((FriendFeedActivity) this.a).getLayoutMode().a(i == 1);
        ((FriendFeedActivity) this.a).getLayoutMode().a(view);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0407: INVOKE  (r2v13 long A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.PraiseData : 0x0403: INVOKE  (r2v12 com.baidu.tbadk.core.data.PraiseData A[REMOVE]) = (r6v1 com.baidu.tieba.data.FriendFeedThreadData) type: VIRTUAL call: com.baidu.tieba.data.FriendFeedThreadData.getPraise():com.baidu.tbadk.core.data.PraiseData)
     type: VIRTUAL call: com.baidu.tbadk.core.data.PraiseData.getNum():long)] */
    private View a(int i, View view, int i2) {
        s sVar;
        int color;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(v.frs_item, (ViewGroup) null);
            s sVar2 = new s(this, null);
            sVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list);
            sVar2.s = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_item_user_info_view);
            sVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_list_item_top_linear_layout);
            sVar2.j = (HeadImageView) view.findViewById(com.baidu.tieba.u.frs_photo);
            sVar2.i = (UserIconBox) view.findViewById(com.baidu.tieba.u.frs_user_tshow_icon_box);
            sVar2.h = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_author);
            sVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_reply_time);
            sVar2.g = (TextView) view.findViewById(com.baidu.tieba.u.frs_lv_title);
            sVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.abstract_text);
            sVar2.d = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.u.abstract_voice);
            sVar2.e = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.u.abstract_img_layout);
            sVar2.k = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_praise_btn);
            sVar2.l = (ImageView) view.findViewById(com.baidu.tieba.u.frs_praise_icon);
            sVar2.m = (TextView) view.findViewById(com.baidu.tieba.u.frs_praise_num);
            sVar2.n = (LinearLayout) view.findViewById(com.baidu.tieba.u.frs_reply_btn);
            sVar2.o = (TextView) view.findViewById(com.baidu.tieba.u.frs_reply_num);
            sVar2.p = (FrsPraiseView) view.findViewById(com.baidu.tieba.u.frs_praise_list_user_icon);
            sVar2.q = (TextView) view.findViewById(com.baidu.tieba.u.frs_more_abstract);
            sVar2.r = view.findViewById(com.baidu.tieba.u.frs_item_praise_divider_line);
            sVar2.t = (LinearLayout) view.findViewById(com.baidu.tieba.u.live_card_layout);
            sVar2.u = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.u.item_card);
            view.setTag(sVar2);
            sVar = sVar2;
        } else {
            sVar = (s) view.getTag();
        }
        if (i2 == 1) {
            sVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg_1);
            sVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg_1);
        } else {
            sVar.b.setBackgroundResource(com.baidu.tieba.t.frs_item_control_btn_bg);
            sVar.q.setBackgroundResource(com.baidu.tieba.t.frs_item_abstract_more_text_bg);
        }
        sVar.k.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.a, sVar.k, 0, 10, 0, 20);
        sVar.n.setOnClickListener(this);
        com.baidu.adp.lib.util.j.a(this.a, sVar.n, 0, 10, 0, 20);
        sVar.q.setOnClickListener(this);
        sVar.k.setOnTouchListener(new r(this, null));
        sVar.n.setTag(Integer.valueOf(i));
        sVar.k.setTag(Integer.valueOf(i));
        sVar.q.setTag(Integer.valueOf(i));
        ((FriendFeedActivity) this.a).getLayoutMode().a(i2 == 1);
        ((FriendFeedActivity) this.a).getLayoutMode().a(view);
        if (i == 0) {
            if (i2 == 1) {
                sVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.bg_frs_1));
            } else {
                sVar.a.setBackgroundDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.bg_frs));
            }
        } else {
            sVar.a.setBackgroundColor(17170445);
        }
        sVar.a.setPadding(0, i == 0 ? this.h : this.i, 0, 0);
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(i);
        sVar.f.setText(ba.a(friendFeedThreadData.getLast_time_int() * 1000));
        if (com.baidu.tbadk.core.h.a().d()) {
            sVar.j.setVisibility(0);
            String portrait = friendFeedThreadData.getAuthor().getPortrait();
            sVar.j.setUserId(friendFeedThreadData.getAuthor().getUserId());
            sVar.j.setImageDrawable(null);
            sVar.j.a(portrait, 12, false);
        } else {
            sVar.j.setVisibility(8);
        }
        sVar.s.setOnClickListener(new m(this, friendFeedThreadData));
        friendFeedThreadData.getAuthor().getIconInfo();
        this.g = friendFeedThreadData.getAuthor().getTShowInfo();
        if (this.g != null && this.g.size() > 0) {
            sVar.i.setVisibility(0);
            if (i2 == 1) {
                sVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_h_1));
            } else {
                sVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_h));
            }
            sVar.i.a(this.g, 2, this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_width), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_height), this.a.getResources().getDimensionPixelSize(com.baidu.tieba.s.small_icon_margin));
        } else {
            sVar.i.setVisibility(8);
            if (i2 == 1) {
                sVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c_1));
            } else {
                sVar.h.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.cp_cont_c));
            }
        }
        sVar.h.setText(friendFeedThreadData.getAuthor().getUserName());
        sVar.e.setVisibility(0);
        sVar.c.setVisibility(0);
        friendFeedThreadData.parser_title();
        sVar.g.setText(friendFeedThreadData.getSpan_str());
        com.baidu.tieba.util.p B = ai.c().B();
        if (B != null && B.b(friendFeedThreadData.getId())) {
            TextView textView = sVar.g;
            if (i2 == 1) {
                color = this.a.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read_1);
            } else {
                color = this.a.getResources().getColor(com.baidu.tieba.r.listview_item_thread_read);
            }
            textView.setTextColor(color);
        }
        if (friendFeedThreadData.getIs_ntitle() == 1) {
            sVar.g.setVisibility(8);
        } else {
            sVar.g.setVisibility(0);
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
                    sVar.q.setVisibility(0);
                    sVar.c.setText(String.valueOf(stringBuffer.toString().substring(0, 170)) + "...");
                } else {
                    sVar.q.setVisibility(8);
                    sVar.c.setText(stringBuffer.toString());
                }
            } else {
                sVar.q.setVisibility(8);
                sVar.c.setVisibility(8);
            }
        }
        if (com.baidu.tbadk.core.h.a().f()) {
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
                        sVar.e.a(null, friendFeedThreadData.getFname(), friendFeedThreadData.getFid(), friendFeedThreadData.getTid());
                        sVar.e.setShowBig(this.e);
                        sVar.e.setDrawNum(true);
                        sVar.e.setFromCDN(true);
                        sVar.e.a(mediaDataArr, i7);
                        sVar.e.setImageFrom("other");
                    }
                } else {
                    sVar.e.setVisibility(8);
                }
            }
        } else {
            sVar.e.setVisibility(8);
        }
        ArrayList<VoiceData.VoiceModel> voices = friendFeedThreadData.getVoices();
        if (voices != null && voices.size() > 0) {
            sVar.d.setVisibility(0);
            VoiceData.VoiceModel voiceModel = voices.get(0);
            sVar.d.setVoiceModel(voiceModel);
            sVar.d.setTag(voiceModel);
            sVar.d.c();
        } else {
            sVar.d.setVisibility(8);
        }
        if (friendFeedThreadData.getPraise() != null && friendFeedThreadData.getPraise().getNum() > 0) {
            if (com.baidu.tbadk.core.h.a().d()) {
                sVar.p.setVisibility(0);
                sVar.p.setIsFromPb(false);
                sVar.p.a(i2);
                sVar.r.setVisibility(0);
                sVar.p.a(friendFeedThreadData.getPraise(), friendFeedThreadData.getId(), friendFeedThreadData.getFirst_post_id(), false);
            } else {
                sVar.p.setVisibility(8);
                sVar.r.setVisibility(8);
            }
            if (friendFeedThreadData.getPraise().getIsLike() == 1) {
                if (i2 == 1) {
                    sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_click_1);
                } else {
                    sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_click);
                }
            } else if (i2 == 1) {
                sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_normal_1);
            } else {
                sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_normal);
            }
            if (friendFeedThreadData.getPraise().getNum() <= 999999) {
                sVar.m.setText(new StringBuilder().append(friendFeedThreadData.getPraise().getNum()).toString());
            } else {
                sVar.m.setText("999999+");
            }
        } else {
            sVar.r.setVisibility(8);
            sVar.p.setVisibility(8);
            sVar.m.setText(this.a.getResources().getString(x.frs_item_praise_text));
            if (i2 == 1) {
                sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_normal_1);
            } else {
                sVar.l.setImageResource(com.baidu.tieba.t.icon_hand_normal);
            }
        }
        int reply_num = friendFeedThreadData.getReply_num();
        if (reply_num <= 999999) {
            if (reply_num > 0) {
                sVar.o.setText(String.valueOf(reply_num));
            } else {
                sVar.o.setText(this.a.getResources().getString(x.frs_item_reply_text));
            }
        } else {
            sVar.o.setText("999999+");
        }
        if (friendFeedThreadData.getAnchorInfoData().getGroup_id() != 0) {
            sVar.e.setVisibility(8);
            sVar.t.setVisibility(0);
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
            sVar.u.setData(liveCardData);
            sVar.u.setStatisticsKey("notice_frs_live");
        } else {
            sVar.t.setVisibility(8);
        }
        return view;
    }

    public void a(q qVar) {
        this.m = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) getItem(intValue);
            View childAt = this.l.getChildAt(intValue - (this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()));
            if (view.getId() == d()) {
                if (this.k) {
                    this.m.a(id, intValue, view, childAt, friendFeedThreadData);
                }
            } else if (view.getId() == com.baidu.tieba.u.frs_live_upItem) {
                com.baidu.tbadk.core.f.a(this.a, "all_live_read");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.u(this.a, friendFeedThreadData.getFid(), false)));
            } else {
                this.m.a(id, intValue, view, childAt, friendFeedThreadData);
            }
        }
    }

    public int d() {
        return com.baidu.tieba.u.frs_praise_btn;
    }

    public int e() {
        return com.baidu.tieba.u.frs_reply_btn;
    }

    public int f() {
        return com.baidu.tieba.u.frs_more_abstract;
    }

    public void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.praise_animation_scale2));
            new Handler().postDelayed(new n(this), 200L);
        }
    }

    public void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.praise_animation_scale3));
            new Handler().postDelayed(new o(this), 600L);
        }
    }

    public void a(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.praise_animation_scale1));
    }
}
