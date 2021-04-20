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
    public ViewGroup f15727a;

    /* renamed from: b  reason: collision with root package name */
    public View f15728b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15729c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15730d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15731e;

    /* renamed from: f  reason: collision with root package name */
    public int f15732f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f15733g;

    /* renamed from: h  reason: collision with root package name */
    public int f15734h;
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
        this.f15733g = new Rect();
        this.i = new a(2921397);
        this.f15728b = view;
        this.f15727a = viewGroup;
        this.f15729c = (LinearLayout) view.findViewById(R.id.container);
        this.f15731e = (ImageView) view.findViewById(R.id.emotion_view);
        this.f15730d = (TextView) view.findViewById(R.id.no_data_tips);
        SkinManager.setImageResource(this.f15731e, R.drawable.new_pic_emotion_06);
        this.i.setTag(j);
        MessageManager.getInstance().registerListener(this.i);
        e();
    }

    public final void d(int i) {
        if (this.f15728b == null || this.f15727a == null) {
            return;
        }
        if (this.f15732f <= 0) {
            this.f15732f = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (i == Integer.MAX_VALUE && this.f15734h == Integer.MAX_VALUE) {
            return;
        }
        this.f15734h = i;
        if (this.f15727a.getLocalVisibleRect(this.f15733g)) {
            int i2 = this.f15733g.bottom;
            int abs = Math.abs(this.f15729c.getTop());
            int abs2 = i2 - Math.abs(this.f15729c.getBottom());
            ViewGroup.LayoutParams layoutParams = this.f15729c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i3 = this.f15732f;
                if (abs < i3) {
                    marginLayoutParams.topMargin = i3;
                    this.f15729c.setLayoutParams(marginLayoutParams);
                } else if (abs == i3) {
                    if (abs2 > i3) {
                        marginLayoutParams.topMargin = i3 + ((abs2 - i3) / 2);
                        this.f15729c.setLayoutParams(marginLayoutParams);
                    }
                } else if (abs > i3) {
                    if (abs2 < i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 == i3) {
                        marginLayoutParams.topMargin = i3;
                    } else if (abs2 > i3) {
                        marginLayoutParams.topMargin = (abs + abs2) / 2;
                    }
                    this.f15729c.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public final void e() {
        View view = this.f15728b;
        if (view == null) {
            return;
        }
        view.addOnLayoutChangeListener(new b());
    }

    public final boolean f(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.f15733g);
    }
}
