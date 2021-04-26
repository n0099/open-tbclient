package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.android.material.appbar.AppBarLayout;
import d.a.i0.t.k;
import d.a.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public PublishButton f17021e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17022f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17023g;

    /* renamed from: h  reason: collision with root package name */
    public f f17024h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f17025i;
    public float j;
    public ImageView k;
    public Context l;
    public MessageRedDotView m;
    public boolean n;
    public View.OnClickListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 16)
        public void onGlobalLayout() {
            if (NestedScrollHeader.this.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
                AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) NestedScrollHeader.this.getLayoutParams();
                layoutParams.setScrollFlags(5);
                NestedScrollHeader.this.setLayoutParams(layoutParams);
            }
            NestedScrollHeader.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17027a;

        public b(String str) {
            this.f17027a = str;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.a.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                NestedScrollHeader.this.f17025i = null;
                NestedScrollHeader.this.f17022f.setImageResource(R.drawable.icon_mask_coin44);
                NestedScrollHeader.this.f17022f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            NestedScrollHeader.this.f17025i = aVar.p();
            NestedScrollHeader.this.f17022f.setImageBitmap(NestedScrollHeader.this.f17025i);
            NestedScrollHeader.this.f17022f.setTag(R.id.homepage_mission_entrance_url, this.f17027a);
            NestedScrollHeader.this.f17022f.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (NestedScrollHeader.this.f17022f == view) {
                    Object tag = NestedScrollHeader.this.f17022f.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (NestedScrollHeader.this.f17024h != null) {
                            NestedScrollHeader.this.f17024h.a(str);
                        }
                        NestedScrollHeader.this.o();
                    }
                } else if (NestedScrollHeader.this.f17023g != view) {
                    if (NestedScrollHeader.this.f17021e != view) {
                        if (NestedScrollHeader.this.k == view) {
                            HashMap hashMap = new HashMap();
                            String str2 = "1";
                            hashMap.put("open_flag", NestedScrollHeader.this.n ? "1" : "2");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(NestedScrollHeader.this.l, "GameCenterListPage", hashMap)));
                            if (NestedScrollHeader.this.m != null) {
                                NestedScrollHeader.this.m.setVisibility(4);
                                d.a.i0.r.d0.b.j().t("key_home_game_center_entrance_rot", true);
                            }
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_GAMECENTER);
                            if (!NestedScrollHeader.this.n) {
                                str2 = "2";
                            }
                            TiebaStatic.log(statisticItem.param("obj_type", str2));
                            NestedScrollHeader.this.n = true;
                        }
                    } else if (WriteActivityConfig.isAsyncWriting()) {
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.f17022f.getVisibility() == 0) {
                NestedScrollHeader.this.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public ImageView getTaskView() {
        return this.f17022f;
    }

    public final void n(Context context) {
        this.l = context;
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.f17021e = (PublishButton) findViewById(R.id.publish_btn);
        this.f17022f = (TbImageView) findViewById(R.id.task);
        this.f17023g = (TextView) findViewById(R.id.search);
        this.k = (ImageView) findViewById(R.id.game_center);
        this.m = (MessageRedDotView) findViewById(R.id.game_center_rot);
        this.f17021e.setOnClickListener(this.o);
        this.f17022f.setOnClickListener(this.o);
        this.f17023g.setOnClickListener(this.o);
        this.k.setOnClickListener(this.o);
        this.m.f(0);
        if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
            this.k.setVisibility(0);
            this.m.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
        }
        boolean g2 = d.a.i0.r.d0.b.j().g("key_home_game_center_entrance_rot", false);
        this.n = g2;
        if (g2) {
            this.m.setVisibility(8);
        } else if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
            this.m.setVisibility(0);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        q();
        p();
    }

    public final void o() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.q);
    }

    public void p() {
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f17023g);
        d2.q(R.color.CAM_X0109);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0210);
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.j, TbadkCoreApplication.getInst().getSkinType());
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
        MessageRedDotView messageRedDotView = this.m;
        if (messageRedDotView != null) {
            messageRedDotView.e();
        }
        Bitmap bitmap = this.f17025i;
        if (bitmap == null) {
            SkinManager.setImageResource(this.f17022f, R.drawable.icon_mask_coin44);
        } else {
            TbImageView tbImageView = this.f17022f;
            if (tbImageView != null) {
                tbImageView.setImageBitmap(bitmap);
            }
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_search_import16, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.f17023g.setCompoundDrawables(pureDrawable, null, null, null);
    }

    public final void q() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
            d.a.c.e.l.d.h().m(missionEntranceIcon, 10, new b(missionEntranceUrl), null);
            return;
        }
        this.f17025i = null;
        this.f17022f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f17022f.setImageResource(R.drawable.icon_mask_coin44);
    }

    public void r(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.j = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        if (this.f17022f.getVisibility() == 0 && this.f17022f.getAlpha() != f2) {
            this.f17022f.setAlpha(f2);
        }
        if (this.k.getVisibility() == 0 && this.k.getAlpha() != f2) {
            this.k.setAlpha(f2);
        }
        if (this.m.getVisibility() == 0 && this.m.getAlpha() != f2) {
            this.m.setAlpha(f2);
        }
        if (this.f17023g.getAlpha() != f2) {
            this.f17023g.setAlpha(f2);
        }
        if (this.f17021e.getVisibility() != 0 || this.f17021e.getAlpha() == f2) {
            return;
        }
        this.f17021e.setAlpha(f2);
        this.f17021e.setScrollAlpha(f2);
    }

    public void setEntranceJumpListener(f fVar) {
        this.f17024h = fVar;
    }

    public void setSearchHint(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f17023g.setText(str);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 1.0f;
        this.o = new c();
        this.p = new d(2921396);
        this.q = new e(2001371);
        n(context);
    }
}
