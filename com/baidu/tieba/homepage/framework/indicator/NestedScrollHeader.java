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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.android.material.appbar.AppBarLayout;
import d.b.h0.t.j;
/* loaded from: classes3.dex */
public class NestedScrollHeader extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public PublishButton f17083e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f17084f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17085g;

    /* renamed from: h  reason: collision with root package name */
    public f f17086h;
    public Bitmap i;
    public float j;
    public View.OnClickListener k;
    public CustomMessageListener l;
    public CustomMessageListener m;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17088a;

        public b(String str) {
            this.f17088a = str;
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
        }

        @Override // d.b.b.e.l.c
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((b) aVar, str, i);
            if (aVar == null || aVar.p() == null || aVar.p().isRecycled()) {
                NestedScrollHeader.this.i = null;
                NestedScrollHeader.this.f17084f.setImageResource(R.drawable.icon_mask_coin44);
                NestedScrollHeader.this.f17084f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                return;
            }
            NestedScrollHeader.this.i = aVar.p();
            NestedScrollHeader.this.f17084f.setImageBitmap(NestedScrollHeader.this.i);
            NestedScrollHeader.this.f17084f.setTag(R.id.homepage_mission_entrance_url, this.f17088a);
            NestedScrollHeader.this.f17084f.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (NestedScrollHeader.this.f17084f == view) {
                    Object tag = NestedScrollHeader.this.f17084f.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (NestedScrollHeader.this.f17086h != null) {
                            NestedScrollHeader.this.f17086h.a(str);
                        }
                        NestedScrollHeader.this.j();
                    }
                } else if (NestedScrollHeader.this.f17085g != view) {
                    if (NestedScrollHeader.this.f17083e != view || WriteActivityConfig.isAsyncWriting()) {
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(1)));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.f17084f.getVisibility() == 0) {
                NestedScrollHeader.this.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public ImageView getTaskView() {
        return this.f17084f;
    }

    public final void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.f17083e = (PublishButton) findViewById(R.id.publish_btn);
        this.f17084f = (TbImageView) findViewById(R.id.task);
        this.f17085g = (TextView) findViewById(R.id.search);
        this.f17083e.setOnClickListener(this.k);
        this.f17084f.setOnClickListener(this.k);
        this.f17085g.setOnClickListener(this.k);
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.m);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        l();
        k();
    }

    public final void j() {
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 1);
        statisticItem.param("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        statisticItem.param("obj_source", TbSingleton.getInstance().getMissionEntranceObjSource());
        TiebaStatic.log(statisticItem);
    }

    public void k() {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f17085g);
        a2.n(R.color.CAM_X0109);
        a2.h(R.string.J_X01);
        a2.c(R.color.CAM_X0210);
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - this.j, TbadkCoreApplication.getInst().getSkinType());
        Bitmap bitmap = this.i;
        if (bitmap == null) {
            SkinManager.setImageResource(this.f17084f, R.drawable.icon_mask_coin44);
        } else {
            TbImageView tbImageView = this.f17084f;
            if (tbImageView != null) {
                tbImageView.setImageBitmap(bitmap);
            }
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_search_import16, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL);
        pureDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
        this.f17085g.setCompoundDrawables(pureDrawable, null, null, null);
    }

    public final void l() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (!TextUtils.isEmpty(missionEntranceUrl) && !TextUtils.isEmpty(missionEntranceIcon)) {
            d.b.b.e.l.d.h().m(missionEntranceIcon, 10, new b(missionEntranceUrl), null);
            return;
        }
        this.i = null;
        this.f17084f.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
        this.f17084f.setImageResource(R.drawable.icon_mask_coin44);
    }

    public void m(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.j = f2;
        SkinManager.setBackgroundColorWithAlpha(this, R.color.CAM_X0208, 1.0f - f2, TbadkCoreApplication.getInst().getSkinType());
        if (this.f17084f.getVisibility() == 0 && this.f17084f.getAlpha() != f2) {
            this.f17084f.setAlpha(f2);
        }
        if (this.f17085g.getAlpha() != f2) {
            this.f17085g.setAlpha(f2);
        }
        if (this.f17083e.getVisibility() != 0 || this.f17083e.getAlpha() == f2) {
            return;
        }
        this.f17083e.setAlpha(f2);
        this.f17083e.setScrollAlpha(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
    }

    public void setEntranceJumpListener(f fVar) {
        this.f17086h = fVar;
    }

    public void setSearchHint(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f17085g.setText(str);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 1.0f;
        this.k = new c();
        this.l = new d(2921396);
        this.m = new e(2001371);
        i(context);
    }
}
