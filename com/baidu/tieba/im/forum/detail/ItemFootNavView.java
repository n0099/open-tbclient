package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.e.p.k;
import d.b.h0.r.s.a;
import d.b.i0.d3.f0;
import d.b.i0.d3.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemFootNavView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ForumDetailActivity f17633e;

    /* renamed from: f  reason: collision with root package name */
    public Context f17634f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f17635g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17636h;
    public ImageView i;
    public ViewGroup j;
    public View k;
    public RecommendForumInfo l;
    public boolean m;
    public d.b.h0.r.s.a n;
    public LikeModel o;
    public AntiHelper.k p;

    /* loaded from: classes4.dex */
    public class a implements AntiHelper.k {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f17638e;

        public b(ForumDetailActivity forumDetailActivity) {
            this.f17638e = forumDetailActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ItemFootNavView.this.q(this.f17638e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f17640e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17641f;

        public c(ForumDetailActivity forumDetailActivity, String str) {
            this.f17640e = forumDetailActivity;
            this.f17641f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(ItemFootNavView.this.f17634f, "detail_enter_forum", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            if (ItemFootNavView.this.m) {
                this.f17640e.finish();
                return;
            }
            this.f17640e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f17640e.getPageContext().getPageActivity()).createNormalCfg(this.f17641f, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
            if (this.f17640e == null || !ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(this.f17640e.getFromType())) {
                return;
            }
            TiebaStatic.eventStat(ItemFootNavView.this.f17633e.getPageContext().getPageActivity(), "squae_introduce_entry", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumDetailActivity f17643a;

        public d(ForumDetailActivity forumDetailActivity) {
            this.f17643a = forumDetailActivity;
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (ItemFootNavView.this.o.getErrorCode() == 22) {
                ItemFootNavView.this.p(true);
                ItemFootNavView.this.r(true);
            } else if (!AntiHelper.m(ItemFootNavView.this.o.getErrorCode(), ItemFootNavView.this.o.getErrorString())) {
                if (ItemFootNavView.this.o.getErrorCode() != 0) {
                    this.f17643a.showToast(ItemFootNavView.this.o.getErrorString());
                    return;
                }
                w wVar = (w) obj;
                if (wVar != null) {
                    if (wVar.d() == 3250013) {
                        BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                        return;
                    } else if (!AntiHelper.l(wVar.d())) {
                        ItemFootNavView.this.p(true);
                        TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.l.forum_name);
                        ItemFootNavView.this.r(true);
                        wVar.v(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                        return;
                    } else {
                        AntiHelper.t(this.f17643a.getPageContext().getPageActivity(), ItemFootNavView.this.o.F(), ItemFootNavView.this.p);
                        return;
                    }
                }
                ForumDetailActivity forumDetailActivity = this.f17643a;
                forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
            } else if (AntiHelper.t(this.f17643a.getPageContext().getPageActivity(), ItemFootNavView.this.o.F(), ItemFootNavView.this.p) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f17645e;

        /* loaded from: classes4.dex */
        public class a implements f0.a {
            public a() {
            }

            @Override // d.b.i0.d3.f0.a
            public void a(String str, long j) {
                if (j == 3250013) {
                    if (k.isEmpty(str)) {
                        str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                    }
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
                    return;
                }
                BaseActivity baseActivity = e.this.f17645e;
                baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
            }

            @Override // d.b.i0.d3.f0.a
            public void b(String str, long j) {
                ItemFootNavView.this.p(false);
                ItemFootNavView.this.r(false);
                if (ItemFootNavView.this.l == null || ItemFootNavView.this.l.forum_id.longValue() == 0) {
                    return;
                }
                w wVar = new w();
                wVar.s(j + "");
                wVar.v(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                MessageManager messageManager = MessageManager.getInstance();
                messageManager.sendMessage(new CustomMessage(2003004, ItemFootNavView.this.l.forum_id + ""));
            }
        }

        public e(BaseActivity baseActivity) {
            this.f17645e = baseActivity;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ItemFootNavView.this.n.dismiss();
            f0 f0Var = new f0();
            f0Var.a(BarDetailForDirSwitch.BAR_DETAIL_DIR);
            f0Var.b(new a());
            f0Var.c(ItemFootNavView.this.l.forum_name, ItemFootNavView.this.l.forum_id.longValue());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            ItemFootNavView.this.n.dismiss();
        }
    }

    public ItemFootNavView(Context context) {
        super(context);
        this.m = false;
        this.p = new a();
        l(context);
    }

    public final void j(ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.o == null) {
            this.o = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.o.setFrom("detail_follow");
        this.o.setLoadDataCallBack(new d(forumDetailActivity));
        LikeModel likeModel = this.o;
        RecommendForumInfo recommendForumInfo = this.l;
        likeModel.H(recommendForumInfo.forum_name, String.valueOf(recommendForumInfo.forum_id));
    }

    public final void k(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.n == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(baseActivity.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.forum_info_unlike_msg);
            this.n.setPositiveButton(R.string.alert_yes_button, new e(baseActivity));
            this.n.setNegativeButton(R.string.cancel, new f());
            this.n.setCanceledOnTouchOutside(true);
        }
        this.n.create(baseActivity.getPageContext()).show();
    }

    public void l(Context context) {
        this.f17634f = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.f17635g = (ViewGroup) findViewById(R.id.fn_care_box);
        this.f17636h = (TextView) findViewById(R.id.fn_care_btn);
        this.i = (ImageView) findViewById(R.id.icon_brief_care);
        this.j = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.k = findViewById(R.id.foot_line);
    }

    public void m(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().k(i == 1);
        forumDetailActivity.getLayoutMode().j(this);
    }

    public void n(ForumDetailActivity forumDetailActivity) {
    }

    public void o(boolean z) {
        if (z) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
    }

    public final void p(boolean z) {
        View inflate = LayoutInflater.from(this.f17634f).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0111);
        if (z) {
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.f17634f);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.f17633e.saveAcceptNotify(true);
        } else {
            this.f17633e.saveAcceptNotify(false);
        }
        this.f17633e.setSwitch(z);
        this.f17633e.setMsgManageVisibility(z);
    }

    public final void q(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.f17635g.getTag()).intValue();
            if (intValue == 0) {
                k(forumDetailActivity, this.m);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.getFromType())) {
                    TiebaStatic.eventStat(this.f17633e.getPageContext().getPageActivity(), "squae_introduce_focus", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
                j(forumDetailActivity, this.m);
            }
            TiebaStatic.eventStat(this.f17634f, intValue == 1 ? "detail_care_add" : "detail_care_cancel", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        }
    }

    public void r(boolean z) {
        int i;
        if (z) {
            SkinManager.setImageResource(this.i, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.f17635g.setTag(0);
        } else {
            SkinManager.setImageResource(this.i, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.f17635g.setTag(1);
        }
        this.f17636h.setText(this.f17634f.getResources().getString(i));
    }

    public void setData(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        this.f17633e = forumDetailActivity;
        if (recommendForumInfo == null) {
            return;
        }
        this.m = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
        this.l = recommendForumInfo;
        String str = recommendForumInfo.forum_name;
        r(recommendForumInfo.is_like.intValue() == 1);
        this.f17635g.setOnClickListener(new b(forumDetailActivity));
        this.j.setOnClickListener(new c(forumDetailActivity, str));
        setVisibility(0);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = false;
        this.p = new a();
        l(context);
    }
}
