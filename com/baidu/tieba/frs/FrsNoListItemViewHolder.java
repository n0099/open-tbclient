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
    public ViewGroup f15218a;

    /* renamed from: b  reason: collision with root package name */
    public View f15219b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15220c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15221d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15222e;

    /* renamed from: f  reason: collision with root package name */
    public int f15223f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f15224g;

    /* renamed from: h  reason: collision with root package name */
    public int f15225h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f15226i;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (FrsNoListItemViewHolder.this.f(view)) {
                FrsNoListItemViewHolder.this.d(Integer.MAX_VALUE);
            }
        }
    }

    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.f15224g = new Rect();
        this.f15226i = new a(2921397);
        this.f15219b = view;
        this.f15218a = viewGroup;
        this.f15220c = (LinearLayout) view.findViewById(R.id.container);
        this.f15222e = (ImageView) view.findViewById(R.id.emotion_view);
        this.f15221d = (TextView) view.findViewById(R.id.no_data_tips);
        SkinManager.setImageResource(this.f15222e, R.drawable.new_pic_emotion_06);
        this.f15226i.setTag(j);
        MessageManager.getInstance().registerListener(this.f15226i);
        e();
    }

    public final void d(int i2) {
        if (this.f15219b == null || this.f15218a == null) {
            return;
        }
        if (this.f15223f <= 0) {
            this.f15223f = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i2 == Integer.MAX_VALUE && this.f15225h == Integer.MAX_VALUE) {
            return;
        }
        this.f15225h = i2;
        if (this.f15218a.getLocalVisibleRect(this.f15224g)) {
            int i3 = this.f15224g.bottom;
            int abs = Math.abs(this.f15220c.getTop());
            int abs2 = i3 - Math.abs(this.f15220c.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f15220c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i4 = this.f15223f;
                if (abs < i4) {
                    marginLayoutParams.topMargin = i4;
                    this.f15220c.setLayoutParams(marginLayoutParams);
                } else if (abs == i4) {
                    if (abs2 > i4) {
                        marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                        this.f15220c.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i4) {
                    if (abs2 < i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 == i4) {
                        marginLayoutParams.topMargin = i4;
                    } else if (abs2 > i4) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f15220c.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public final void e() {
        View view = this.f15219b;
        if (view == null) {
            return;
        }
        view.addOnLayoutChangeListener(new b());
    }

    public final boolean f(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.f15224g);
    }
}
