package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static BdUniqueId j = BdUniqueId.gen();

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f16065a;

    /* renamed from: b  reason: collision with root package name */
    public View f16066b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16067c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16068d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16069e;

    /* renamed from: f  reason: collision with root package name */
    public int f16070f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f16071g;

    /* renamed from: h  reason: collision with root package name */
    public int f16072h;
    public CustomMessageListener i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            FrsNoListItemViewHolder.this.d(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (FrsNoListItemViewHolder.this.f(view)) {
                FrsNoListItemViewHolder.this.d(Integer.MAX_VALUE);
            }
        }
    }

    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.f16071g = new Rect();
        this.i = new a(2921397);
        this.f16066b = view;
        this.f16065a = viewGroup;
        this.f16067c = (LinearLayout) view.findViewById(R.id.container);
        this.f16069e = (ImageView) view.findViewById(R.id.emotion_view);
        this.f16068d = (TextView) view.findViewById(R.id.no_data_tips);
        SkinManager.setImageResource(this.f16069e, R.drawable.new_pic_emotion_06);
        this.i.setTag(j);
        MessageManager.getInstance().registerListener(this.i);
        e();
    }

    public final void d(int i) {
        if (this.f16066b == null || this.f16065a == null) {
            return;
        }
        if (this.f16070f <= 0) {
            this.f16070f = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i == Integer.MAX_VALUE && this.f16072h == Integer.MAX_VALUE) {
            return;
        }
        this.f16072h = i;
        if (this.f16065a.getLocalVisibleRect(this.f16071g)) {
            int i2 = this.f16071g.bottom;
            int abs = Math.abs(this.f16067c.getTop());
            int abs2 = i2 - Math.abs(this.f16067c.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f16067c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i3 = this.f16070f;
                if (abs < i3) {
                    marginLayoutParams.topMargin = i3;
                    this.f16067c.setLayoutParams(marginLayoutParams);
                } else if (abs == i3) {
                    if (abs2 > i3) {
                        marginLayoutParams.topMargin = i3 + ((abs2 - i3) / 2);
                        this.f16067c.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i3) {
                    if (abs2 < i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 == i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 > i3) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f16067c.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public final void e() {
        View view = this.f16066b;
        if (view == null) {
            return;
        }
        view.addOnLayoutChangeListener(new b());
    }

    public final boolean f(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.f16071g);
    }
}
