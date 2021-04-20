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
import d.b.h0.t.k;
import d.b.i0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public PublishButton f16756e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f16757f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16758g;

    /* renamed from: h  reason: collision with root package name */
    public f f16759h;
    public Bitmap i;
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
    public class b extends d.b.c.e.l.c<d.b.c.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16761a;

        public b(String str) {
            this.f16761a = str;
        }

        @Override // d.b.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.c.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((b) aVar, str, i);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                NestedScrollHeader.this.i = null;
                NestedScrollHeader.this.f16757f.setImageResource(R.drawable.icon_mask_coin44);
                NestedScrollHeader.this.f16757f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            NestedScrollHeader.this.i = aVar.p();
            NestedScrollHeader.this.f16757f.setImageBitmap(NestedScrollHeader.this.i);
            NestedScrollHeader.this.f16757f.setTag(R.id.homepage_mission_entrance_url, this.f16761a);
            NestedScrollHeader.this.f16757f.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (NestedScrollHeader.this.f16757f == view) {
                    Object tag = NestedScrollHeader.this.f16757f.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (NestedScrollHeader.this.f16759h != null) {
                            NestedScrollHeader.this.f16759h.a(str);
                        }
                        NestedScrollHeader.this.n();
                    }
                } else if (NestedScrollHeader.this.f16758g != view) {
                    if (NestedScrollHeader.this.f16756e != view) {
                        if (NestedScrollHeader.this.k == view) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("open_flag", NestedScrollHeader.this.n ? "1" : "2");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(NestedScrollHeader.this.l, "GameCenterListPage", hashMap)));
                            if (NestedScrollHeader.this.m != null) {
                                NestedScrollHeader.this.m.setVisibility(4);
                                d.b.h0.r.d0.b.j().t("key_home_game_center_entrance_rot", true);
                            }
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
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.f16757f.getVisibility() == 0) {
                NestedScrollHeader.this.p();
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
        return this.f16757f;
    }

    public final void m(Context context) {
        this.l = context;
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.f16756e = (PublishButton) findViewById(R.id.publish_btn);
        this.f16757f = (TbImageView) findViewById(R.id.task);
        this.f16758g = (TextView) findViewById(R.id.search);
        this.k = (ImageView) findViewById(R.id.game_center);
        this.m = (MessageRedDotView) findViewById(R.id.game_center_rot);
        this.f16756e.setOnClickListener(this.o);
        this.f16757f.setOnClickListener(this.o);
        this.f16758g.setOnClickListener(this.o);
        this.k.setOnClickListener(this.o);
        this.m.f(0);
        boolean g2 = d.b.h0.r.d0.b.j().g("key_home_game_center_entrance_rot", false);
        this.n = g2;
        if (g2) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        p();
        o();
    }

    public final void n() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public void o() {
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f16758g);
        d2.q(R.color.CAM_X0109);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0210);
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.j, TbadkCoreApplication.getInst().getSkinType());
        WebPManager.setMaskDrawable(this.k, R.drawable.icon_home_new_games, WebPManager.ResourceStateType.NORMAL);
        MessageRedDotView messageRedDotView = this.m;
        if (messageRedDotView != null) {
            messageRedDotView.e();
        }
        Bitmap bitmap = this.i;
        if (bitmap == null) {
            SkinManager.setImageResource(this.f16757f, R.drawable.icon_mask_coin44);
        } else {
            TbImageView tbImageView = this.f16757f;
            if (tbImageView != null) {
                tbImageView.setImageBitmap(bitmap);
            }
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_search_import16, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.f16758g.setCompoundDrawables(pureDrawable, null, null, null);
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

    public final void p() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
            d.b.c.e.l.d.h().m(missionEntranceIcon, 10, new b(missionEntranceUrl), null);
            return;
        }
        this.i = null;
        this.f16757f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f16757f.setImageResource(R.drawable.icon_mask_coin44);
    }

    public void q(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.j = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        if (this.f16757f.getVisibility() == 0 && this.f16757f.getAlpha() != f2) {
            this.f16757f.setAlpha(f2);
        }
        if (this.k.getVisibility() == 0 && this.k.getAlpha() != f2) {
            this.k.setAlpha(f2);
        }
        if (this.m.getVisibility() == 0 && this.m.getAlpha() != f2) {
            this.m.setAlpha(f2);
        }
        if (this.f16758g.getAlpha() != f2) {
            this.f16758g.setAlpha(f2);
        }
        if (this.f16756e.getVisibility() != 0 || this.f16756e.getAlpha() == f2) {
            return;
        }
        this.f16756e.setAlpha(f2);
        this.f16756e.setScrollAlpha(f2);
    }

    public void setEntranceJumpListener(f fVar) {
        this.f16759h = fVar;
    }

    public void setSearchHint(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f16758g.setText(str);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 1.0f;
        this.o = new c();
        this.p = new d(2921396);
        this.q = new e(2001371);
        m(context);
    }
}
