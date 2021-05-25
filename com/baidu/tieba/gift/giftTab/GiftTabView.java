package com.baidu.tieba.gift.giftTab;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftPagerAdapter;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.bumptech.glide.load.engine.GlideException;
import d.a.m0.r.q.i0;
import d.a.m0.r.q.j0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    public FrameLayout A;
    public View B;
    public ListView C;
    public d.a.n0.v0.b.d E;
    public GiftPagerAdapter F;
    public d.a.m0.r.f0.a G;
    public ArrayList<d.a.n0.v0.b.c> H;
    public ArrayList<d.a.n0.v0.b.a> I;
    public ArrayList<d.a.n0.v0.b.e> J;
    public String L;
    public int M;
    public j0 N;
    public o O;
    public n P;
    public i0 U;
    public int X;
    public int Y;
    public int Z;
    public View.OnClickListener a0;
    public int b0;

    /* renamed from: e  reason: collision with root package name */
    public GiftTabActivity f16045e;

    /* renamed from: f  reason: collision with root package name */
    public View f16046f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f16047g;

    /* renamed from: h  reason: collision with root package name */
    public View f16048h;

    /* renamed from: i  reason: collision with root package name */
    public View f16049i;
    public View j;
    public EditText k;
    public View l;
    public TextView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public BaseViewPager u;
    public IndicatorView v;
    public HorizontalScrollView w;
    public LinearLayout x;
    public View y;
    public View z;
    public List<View> D = new ArrayList();
    public int K = 0;
    public int Q = 0;
    public int R = 0;
    public int S = 0;
    public int T = 0;
    public SparseIntArray V = new SparseIntArray();
    public SparseBooleanArray W = new SparseBooleanArray();
    public View.OnClickListener c0 = new a();
    public View.OnClickListener d0 = new b();
    public Handler e0 = new Handler();
    public Runnable f0 = new i();
    public boolean g0 = false;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNull(GiftTabView.this.N.f50057b)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(GiftTabView.this.f16045e.getPageContext(), new String[]{GiftTabView.this.N.f50057b});
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.l.x(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GiftTabView.this.B.getVisibility() != 0) {
                GiftTabView.this.f16045e.closeActivity();
            } else {
                GiftTabView.this.B.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                GiftTabView.this.w(false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.Y, -2);
                int[] iArr = new int[2];
                GiftTabView.this.k.getLocationOnScreen(iArr);
                layoutParams.leftMargin = iArr[0] - GiftTabView.this.Z;
                int i2 = (iArr[1] - GiftTabView.this.X) - GiftTabView.this.Z;
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 += UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = i2;
                GiftTabView.this.C.setLayoutParams(layoutParams);
                GiftTabView.this.B.setVisibility(0);
            }
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.l.x(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
            GiftTabView.this.f16045e.mHandler.postDelayed(new a(), 200L);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                d.a.c.e.p.l.K(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
            } else {
                d.a.c.e.p.l.x(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GiftTabView.this.B.setVisibility(8);
            d.a.c.e.p.l.x(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GiftTabView.this.O != null) {
                GiftTabView.this.W.append(GiftTabView.this.T, true);
                GiftTabView.this.O.a(((d.a.n0.v0.b.c) GiftTabView.this.H.get(GiftTabView.this.T)).a());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GiftTabView.this.P != null) {
                GiftTabView.this.P.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.S();
            GiftTabView.this.y(true);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            GiftTabView giftTabView = GiftTabView.this;
            giftTabView.R = giftTabView.Q;
            GiftTabView.this.S = i2;
            d.a.c.e.p.l.x(GiftTabView.this.f16045e.getPageContext().getPageActivity(), GiftTabView.this.k);
            d.a.n0.v0.b.b bVar = (d.a.n0.v0.b.b) adapterView.getAdapter();
            if (bVar != null) {
                i0 item = bVar.getItem(i2);
                if (item != null) {
                    GiftTabView.this.U = item;
                }
                bVar.d(i2);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.L();
            GiftTabView.this.y(true);
        }

        public /* synthetic */ j(GiftTabView giftTabView, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements AdapterView.OnItemClickListener {
        public k() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (GiftTabView.this.J == null || GiftTabView.this.J.size() <= 0) {
                GiftTabView.this.w(true);
                Selection.selectAll(GiftTabView.this.k.getText());
                GiftTabView.this.B.setVisibility(8);
                GiftTabView.this.y(true);
                return;
            }
            if (i2 == GiftTabView.this.J.size()) {
                GiftTabView.this.w(true);
                Selection.selectAll(GiftTabView.this.k.getText());
            } else {
                GiftTabView.this.k.setCursorVisible(true);
                GiftTabView.this.k.setFocusable(true);
                d.a.n0.v0.b.e eVar = (d.a.n0.v0.b.e) GiftTabView.this.J.get(i2);
                if (eVar != null) {
                    EditText editText = GiftTabView.this.k;
                    editText.setText("" + eVar.b());
                }
            }
            GiftTabView.this.B.setVisibility(8);
            GiftTabView.this.y(true);
        }

        public /* synthetic */ k(GiftTabView giftTabView, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TextWatcher {
        public l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int d2 = d.a.c.e.m.b.d(editable.toString(), 0);
            if (editable.toString().length() == String.valueOf(d2).length()) {
                GiftTabView.this.y(true);
                return;
            }
            int i2 = d2 >= 0 ? d2 : 0;
            EditText editText = GiftTabView.this.k;
            editText.setText("" + i2);
            GiftTabView.this.k.setSelection(String.valueOf(i2).length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public /* synthetic */ l(GiftTabView giftTabView, a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public int f16063e;

        public m(int i2) {
            this.f16063e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.f16063e, GiftTabView.this.V.size());
            int i2 = 0;
            for (int i3 = 0; i3 < min; i3++) {
                i2 += GiftTabView.this.V.get(i3);
            }
            GiftTabView.this.Q = i2;
            GiftTabView giftTabView = GiftTabView.this;
            giftTabView.u.setCurrentItem(giftTabView.Q);
            GiftTabView.this.T();
        }
    }

    /* loaded from: classes4.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface o {
        void a(int i2);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f16045e = giftTabActivity;
        this.a0 = onClickListener;
        View inflate = LayoutInflater.from(giftTabActivity.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.f16046f = inflate;
        this.f16045e.setContentView(inflate);
        J();
        this.X = d.a.c.e.p.l.r(this.f16045e.getActivity());
        this.Y = d.a.c.e.p.l.g(this.f16045e.getActivity(), R.dimen.ds330);
        this.Z = d.a.c.e.p.l.g(this.f16045e.getActivity(), R.dimen.ds10);
    }

    public void A() {
        this.e0.removeCallbacks(this.f0);
    }

    public int B() {
        return this.b0;
    }

    public i0 C() {
        return this.U;
    }

    public final View D(boolean z) {
        View inflate = LayoutInflater.from(this.f16045e.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.net_refresh_button);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setImageResource((TbImageView) inflate.findViewById(R.id.net_refresh_image), R.drawable.new_pic_emotion_08);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.net_refresh_title), R.color.CAM_X0105, 1, skinType);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, skinType);
        SkinManager.setBackgroundResource(textView, R.drawable.btn_appdownload, skinType);
        if (z) {
            textView.setOnClickListener(new g());
        } else {
            textView.setOnClickListener(new h());
        }
        return inflate;
    }

    public final GridView E(List<i0> list, int i2) {
        d.a.n0.v0.b.b bVar = new d.a.n0.v0.b.b(this.f16045e.getPageContext().getPageActivity());
        bVar.c(list);
        bVar.d(i2);
        TableLineGridView tableLineGridView = new TableLineGridView(this.f16045e.getPageContext().getPageActivity());
        tableLineGridView.setColumnCount(4);
        tableLineGridView.setRowCount(2);
        tableLineGridView.setBackgroundLineResource(SkinManager.getColor(R.color.CAM_X0204));
        tableLineGridView.setVerticalScrollBarEnabled(false);
        tableLineGridView.setNumColumns(4);
        tableLineGridView.setSelector(R.color.common_color_10022);
        tableLineGridView.setAdapter((ListAdapter) bVar);
        tableLineGridView.setOnItemClickListener(new j(this, null));
        return tableLineGridView;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void F(int i2) {
        int childCount = this.x.getChildCount();
        if (i2 < 0 || i2 >= childCount) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout = (LinearLayout) this.x.getChildAt(i3);
            TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
            View findViewById = linearLayout.findViewById(R.id.text_divider_line);
            if (i3 != i2) {
                SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                SkinManager.setBackgroundColor(findViewById, R.color.common_color_10022);
                textView.setEnabled(true);
                findViewById.setEnabled(true);
            } else {
                SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                SkinManager.setBackgroundColor(findViewById, R.color.gift_tab_textcolor_selected);
                textView.setEnabled(false);
                findViewById.setEnabled(false);
                x(i2);
                this.T = i2;
                this.w.scrollTo(linearLayout.getLeft(), 0);
            }
        }
    }

    public void G() {
        d.a.m0.r.f0.a aVar = this.G;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public final void H(ArrayList<d.a.n0.v0.b.c> arrayList, boolean z) {
        List<i0> subList;
        if (arrayList == null) {
            return;
        }
        this.V.clear();
        this.D.clear();
        this.u.setAdapter(null);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<i0> b2 = arrayList.get(i2).b();
            int size = b2 != null ? b2.size() : 0;
            int i3 = 1;
            if (size <= 0) {
                List<i0> arrayList2 = new ArrayList<>();
                if (!this.W.get(i2)) {
                    this.D.add(E(arrayList2, -1));
                } else {
                    this.D.add(D(true));
                }
            } else {
                int ceil = (int) Math.ceil(size / 8.0d);
                for (int i4 = 0; i4 < ceil; i4++) {
                    if (i4 == ceil - 1) {
                        int i5 = i4 * 8;
                        int i6 = size - 1;
                        if (i5 == i6) {
                            subList = new ArrayList<>();
                            subList.add(b2.get(i6));
                        } else {
                            subList = b2.subList(i5, size);
                        }
                    } else {
                        subList = b2.subList(i4 * 8, (i4 + 1) * 8);
                    }
                    if (i2 == 0 && i4 == 0 && z) {
                        this.D.add(E(subList, 0));
                        this.U = subList.get(0);
                    } else {
                        this.D.add(E(subList, -1));
                    }
                }
                i3 = ceil;
            }
            this.V.append(i2, i3);
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.D);
        this.F = giftPagerAdapter;
        this.u.setAdapter(giftPagerAdapter);
        this.u.setCurrentItem(this.Q);
        T();
    }

    public final void I(List<d.a.n0.v0.b.e> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (d.a.n0.v0.b.e eVar : list) {
                if (eVar.b() <= 0) {
                    arrayList.add(eVar);
                }
            }
            list.removeAll(arrayList);
        }
        d.a.n0.v0.b.d dVar = new d.a.n0.v0.b.d(this.f16045e.getPageContext().getPageActivity());
        this.E = dVar;
        this.C.setAdapter((ListAdapter) dVar);
        this.E.b(list);
    }

    public final void J() {
        this.f16047g = (FrameLayout) this.f16046f.findViewById(R.id.gift_panel_lay);
        View findViewById = this.f16046f.findViewById(R.id.empty_layout);
        this.f16048h = findViewById;
        findViewById.setOnClickListener(new c());
        View findViewById2 = this.f16046f.findViewById(R.id.gift_count_layout);
        this.j = findViewById2;
        findViewById2.setOnClickListener(this.d0);
        this.f16049i = this.f16046f.findViewById(R.id.gift_list_layout);
        EditText editText = (EditText) this.f16046f.findViewById(R.id.gift_count_input);
        this.k = editText;
        editText.setSelection(1);
        w(false);
        this.k.addTextChangedListener(new l(this, null));
        this.k.setOnClickListener(new d());
        this.k.setOnFocusChangeListener(new e());
        this.l = this.f16046f.findViewById(R.id.reward_parent_view);
        this.m = (TextView) this.f16046f.findViewById(R.id.reward_count_result);
        this.n = (TextView) this.f16046f.findViewById(R.id.reward_jump);
        this.o = (ImageView) this.f16046f.findViewById(R.id.reward_jump_arrow);
        this.l.setOnClickListener(this.c0);
        this.p = (TextView) this.f16046f.findViewById(R.id.gift_count_result);
        TextView textView = (TextView) this.f16046f.findViewById(R.id.gift_button);
        this.q = textView;
        textView.setEnabled(false);
        this.q.setOnClickListener(this.a0);
        TextView textView2 = (TextView) this.f16046f.findViewById(R.id.gift_desc_view);
        this.r = textView2;
        textView2.setOnClickListener(this.d0);
        TextView textView3 = (TextView) this.f16046f.findViewById(R.id.get_free_chance_view);
        this.s = textView3;
        textView3.setOnClickListener(this.a0);
        TextView textView4 = (TextView) this.f16046f.findViewById(R.id.text_view_gift_to);
        this.t = textView4;
        textView4.setOnClickListener(this.d0);
        this.y = this.f16046f.findViewById(R.id.gift_lower_layout);
        BaseViewPager baseViewPager = (BaseViewPager) this.f16046f.findViewById(R.id.gift_viewpager);
        this.u = baseViewPager;
        baseViewPager.setOnPageChangeListener(this);
        this.v = (IndicatorView) this.f16046f.findViewById(R.id.gift_tab_indicator);
        this.x = (LinearLayout) this.f16046f.findViewById(R.id.gift_tab_layout);
        this.w = (HorizontalScrollView) this.f16046f.findViewById(R.id.gift_tab_scrollview);
        View findViewById3 = this.f16046f.findViewById(R.id.gift_num_layout);
        this.B = findViewById3;
        findViewById3.setOnClickListener(new f());
        ListView listView = (ListView) this.f16046f.findViewById(R.id.gift_num_list);
        this.C = listView;
        listView.setOnItemClickListener(new k(this, null));
        this.A = (FrameLayout) this.f16046f.findViewById(R.id.tab_container_view);
        View D = D(false);
        this.z = D;
        D.setVisibility(8);
        this.A.addView(this.z);
    }

    public void K(int i2) {
        d.a.m0.s0.a.a(this.f16045e.getPageContext(), this.f16049i);
        SkinManager.setBackgroundResource(this.C, R.drawable.chx_box_im_gift);
        d.a.n0.v0.b.d dVar = this.E;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        this.v.setSelector(SkinManager.getDrawable(R.drawable.point_live_s));
        this.v.setDrawable(SkinManager.getDrawable(R.drawable.point_live_n));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L() {
        String str;
        long j2;
        String timeSpace;
        String format;
        String str2;
        String str3;
        String string;
        String string2;
        String formatOverBaiwanNum;
        String formatOverBaiwanNum2;
        if (this.f16045e.accountType == 1) {
            this.f16046f.findViewById(R.id.desc_parent_view).setVisibility(8);
            return;
        }
        i0 i0Var = this.U;
        if (i0Var == null) {
            return;
        }
        int i2 = i0Var.f50048f;
        String str4 = "";
        if (StringUtils.isNull(i0Var.f50047e)) {
            str = "";
        } else {
            str = "\"" + this.U.f50047e + "\" ";
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "" + this.U.k;
                str4 = String.format(this.f16045e.getPageContext().getString(R.string.left_number), Integer.valueOf(this.U.k));
            } else if (i2 == 3) {
                if (CurrencySwitchUtil.isYyIsConvert(this.U.s)) {
                    string = this.f16045e.getPageContext().getString(R.string.original_price_ybean);
                    string2 = this.f16045e.getPageContext().getString(R.string.discount_price_ybean);
                    i0 i0Var2 = this.U;
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(i0Var2.s, i0Var2.b());
                    i0 i0Var3 = this.U;
                    formatOverBaiwanNum2 = CurrencyHelper.getFormatOverBaiwanNum(i0Var3.s, i0Var3.a());
                } else {
                    string = this.f16045e.getPageContext().getString(R.string.original_price);
                    string2 = this.f16045e.getPageContext().getString(R.string.discount_price);
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(this.U.b());
                    formatOverBaiwanNum2 = StringHelper.formatOverBaiwanNum(this.U.a());
                }
                String format2 = String.format(string, formatOverBaiwanNum);
                str2 = String.format(string2, formatOverBaiwanNum2);
                j2 = 0;
                str3 = format2;
                str4 = " " + format2 + GlideException.IndentedAppendable.INDENT + str2;
                if (i2 != 5 && this.K <= 0 && !StringUtils.isNull(this.L)) {
                    this.s.setVisibility(0);
                } else {
                    this.s.setVisibility(8);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) d.a.n0.v0.b.g.c(str4, str2, str3));
                this.r.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.e0.removeCallbacks(this.f0);
                    return;
                } else if (j2 > 0 && j2 <= VideoCloudSetting.HOUR_MILLISECOND) {
                    this.g0 = true;
                    this.e0.postDelayed(this.f0, 1000L);
                    return;
                } else if (this.g0) {
                    this.g0 = false;
                    this.e0.postDelayed(this.f0, 1000L);
                    return;
                } else {
                    return;
                }
            } else {
                if (i2 != 4 && i2 == 5) {
                    if (this.K > 0) {
                        String format3 = String.format(this.f16045e.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.K));
                        this.k.setText("" + this.K);
                        str4 = format3;
                        str2 = "" + this.K;
                    } else {
                        this.k.setText("0");
                        this.q.setEnabled(false);
                        str4 = this.f16045e.getPageContext().getString(R.string.have_no_free_chance);
                    }
                }
                str3 = null;
                str2 = null;
            }
            str3 = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            i0 i0Var4 = this.U;
            if (currentTimeMillis > i0Var4.f50050h) {
                long j3 = i0Var4.f50051i;
                if (currentTimeMillis < j3) {
                    j2 = (j3 - currentTimeMillis) * 1000;
                    timeSpace = StringHelper.getTimeSpace(j2);
                    format = String.format(this.f16045e.getPageContext().getString(R.string.gift_limit_time_end), timeSpace);
                    str2 = timeSpace;
                    str4 = format;
                    str3 = null;
                    if (i2 != 5) {
                    }
                    this.s.setVisibility(8);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
                    spannableStringBuilder2.append((CharSequence) spannableString2);
                    spannableStringBuilder2.append((CharSequence) d.a.n0.v0.b.g.c(str4, str2, str3));
                    this.r.setText(spannableStringBuilder2);
                    if (i2 == 1) {
                    }
                }
            }
            i0 i0Var5 = this.U;
            long j4 = i0Var5.f50050h;
            if (currentTimeMillis < j4) {
                j2 = (j4 - currentTimeMillis) * 1000;
                timeSpace = StringHelper.getTimeSpace(j2);
                format = String.format(this.f16045e.getPageContext().getString(R.string.gift_limit_time_start), timeSpace);
                str2 = timeSpace;
                str4 = format;
                str3 = null;
                if (i2 != 5) {
                }
                this.s.setVisibility(8);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder();
                SpannableString spannableString22 = new SpannableString(str);
                spannableString22.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString22.length(), 33);
                spannableStringBuilder22.append((CharSequence) spannableString22);
                spannableStringBuilder22.append((CharSequence) d.a.n0.v0.b.g.c(str4, str2, str3));
                this.r.setText(spannableStringBuilder22);
                if (i2 == 1) {
                }
            } else {
                str4 = currentTimeMillis > i0Var5.f50051i ? this.f16045e.getPageContext().getString(R.string.gift_limit_time_has_over) : null;
                str3 = null;
                str2 = null;
            }
        }
        j2 = 0;
        if (i2 != 5) {
        }
        this.s.setVisibility(8);
        SpannableStringBuilder spannableStringBuilder222 = new SpannableStringBuilder();
        SpannableString spannableString222 = new SpannableString(str);
        spannableString222.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString222.length(), 33);
        spannableStringBuilder222.append((CharSequence) spannableString222);
        spannableStringBuilder222.append((CharSequence) d.a.n0.v0.b.g.c(str4, str2, str3));
        this.r.setText(spannableStringBuilder222);
        if (i2 == 1) {
        }
    }

    public void M(String str) {
        this.L = str;
    }

    public void N(int i2) {
        this.K = i2;
        i0 i0Var = this.U;
        if (i0Var == null || i0Var.f50048f != 5) {
            return;
        }
        L();
    }

    public void O(o oVar) {
        this.O = oVar;
    }

    public void P(n nVar) {
        this.P = nVar;
    }

    public void Q(boolean z, ArrayList<d.a.n0.v0.b.c> arrayList, ArrayList<d.a.n0.v0.b.a> arrayList2, ArrayList<d.a.n0.v0.b.e> arrayList3) {
        this.H = arrayList;
        this.I = arrayList2;
        this.J = arrayList3;
        U(z);
    }

    public void R() {
        if (this.G == null) {
            this.G = new d.a.m0.r.f0.a(this.f16045e.getPageContext());
        }
        this.G.h(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S() {
        int i2;
        String str;
        long j2;
        String str2;
        String str3;
        i0 i0Var = this.U;
        if (i0Var == null || (i2 = i0Var.f50048f) != 1) {
            return;
        }
        if (StringUtils.isNull(i0Var.f50047e)) {
            str = "";
        } else {
            str = "\"" + this.U.f50047e + "\" ";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        i0 i0Var2 = this.U;
        if (currentTimeMillis > i0Var2.f50050h) {
            long j3 = i0Var2.f50051i;
            if (currentTimeMillis < j3) {
                j2 = (j3 - currentTimeMillis) * 1000;
                str2 = StringHelper.getTimeSpace(j2);
                str3 = String.format(this.f16045e.getPageContext().getString(R.string.gift_limit_time_end), str2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) d.a.n0.v0.b.g.c(str3, str2, null));
                this.r.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.e0.removeCallbacks(this.f0);
                    return;
                } else if (j2 > 0 && j2 <= VideoCloudSetting.HOUR_MILLISECOND) {
                    this.g0 = true;
                    this.e0.postDelayed(this.f0, 1000L);
                    return;
                } else if (this.g0) {
                    this.g0 = false;
                    this.e0.postDelayed(this.f0, 1000L);
                    return;
                } else {
                    return;
                }
            }
        }
        i0 i0Var3 = this.U;
        long j4 = i0Var3.f50050h;
        if (currentTimeMillis < j4) {
            j2 = (j4 - currentTimeMillis) * 1000;
            str2 = StringHelper.getTimeSpace(j2);
            str3 = String.format(this.f16045e.getPageContext().getString(R.string.gift_limit_time_start), str2);
        } else if (currentTimeMillis > i0Var3.f50051i) {
            str3 = this.f16045e.getPageContext().getString(R.string.gift_limit_time_has_over);
            j2 = 0;
            str2 = null;
        } else {
            j2 = 0;
            str2 = null;
            str3 = null;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        SpannableString spannableString2 = new SpannableString(str);
        spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
        spannableStringBuilder2.append((CharSequence) spannableString2);
        spannableStringBuilder2.append((CharSequence) d.a.n0.v0.b.g.c(str3, str2, null));
        this.r.setText(spannableStringBuilder2);
        if (i2 == 1) {
        }
    }

    public final void T() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.V.size(); i3++) {
            for (int i4 = 0; i4 < this.V.get(i3); i4++) {
                if (i2 + i4 == this.Q) {
                    if (this.V.get(i3) <= 1) {
                        this.v.setVisibility(4);
                    } else {
                        this.v.setVisibility(0);
                    }
                    this.v.setCount(this.V.get(i3));
                    this.v.setPosition(i4);
                    F(i3);
                    return;
                }
            }
            i2 += this.V.get(i3);
        }
    }

    public final void U(boolean z) {
        z();
        G();
        ArrayList<d.a.n0.v0.b.c> arrayList = this.H;
        if (arrayList != null && arrayList.size() > 0) {
            this.q.setEnabled(true);
            this.z.setVisibility(8);
            this.y.setVisibility(0);
            if (z) {
                v(this.I);
                I(this.J);
            }
            H(this.H, z);
            L();
            y(true);
            return;
        }
        this.y.setVisibility(8);
        this.z.setVisibility(0);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.Q = i2;
        T();
        if (i2 < 0 || i2 >= this.D.size() || !(this.D.get(i2) instanceof GridView)) {
            return;
        }
        GridView gridView = (GridView) this.D.get(i2);
        if (gridView.getAdapter() != null) {
            d.a.n0.v0.b.b bVar = (d.a.n0.v0.b.b) gridView.getAdapter();
            if (bVar.b() >= 0 && i2 != this.R) {
                bVar.d(-1);
                bVar.notifyDataSetChanged();
            }
            if (bVar.b() >= 0 || i2 != this.R) {
                return;
            }
            bVar.d(this.S);
            bVar.notifyDataSetChanged();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void v(ArrayList<d.a.n0.v0.b.a> arrayList) {
        int i2;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.x.removeAllViews();
        int size = arrayList.size();
        int k2 = d.a.c.e.p.l.k(this.f16045e.getPageContext().getPageActivity());
        if (size >= 5) {
            i2 = k2 / 5;
        } else {
            i2 = k2 / size;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        for (int i3 = 0; i3 < size; i3++) {
            d.a.n0.v0.b.a aVar = arrayList.get(i3);
            if (!TextUtils.isEmpty(aVar.b()) && aVar.c() != null && aVar.c().size() > 0) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f16045e.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                textView.setText(aVar.b());
                linearLayout.setOnClickListener(new m(i3));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                this.x.addView(linearLayout, layoutParams);
            }
        }
        F(this.T);
    }

    public final void w(boolean z) {
        this.k.setCursorVisible(z);
        this.k.setFocusable(z);
        this.k.setFocusableInTouchMode(z);
        if (z) {
            this.k.requestFocus();
        } else {
            this.k.clearFocus();
        }
    }

    public final void x(int i2) {
        ArrayList<d.a.n0.v0.b.c> arrayList;
        int childCount = this.x.getChildCount();
        if (i2 < 0 || i2 >= childCount || (arrayList = this.H) == null || arrayList.size() <= i2 || this.H.get(i2) == null || this.W.get(i2)) {
            return;
        }
        if ((this.H.get(i2).b() == null || this.H.get(i2).b().size() <= 0) && this.O != null) {
            this.W.append(i2, true);
            this.O.a(this.H.get(i2).a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float y(boolean z) {
        long a2;
        long j2;
        if (this.U == null) {
            return 0.0f;
        }
        int d2 = d.a.c.e.m.b.d(this.k.getText().toString(), 0);
        this.b0 = d2;
        i0 i0Var = this.U;
        int i2 = i0Var.f50048f;
        int i3 = i0Var.s;
        if (i2 == 3) {
            if (i0Var.a() >= 0) {
                a2 = this.U.a();
                j2 = a2 * d2;
                if (z) {
                }
            }
            a2 = 0;
            j2 = a2 * d2;
            if (z) {
            }
        } else if (i2 != 5) {
            if (i0Var.b() >= 0) {
                a2 = this.U.b();
                j2 = a2 * d2;
                if (z) {
                    this.p.setText(d.a.n0.v0.b.g.b(j2, true, i3));
                    if (d2 <= 0) {
                        SkinManager.setBackgroundResource(this.q, R.drawable.btn_gift_give_d);
                        this.q.setEnabled(false);
                    } else if (i2 == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        i0 i0Var2 = this.U;
                        if (currentTimeMillis >= i0Var2.f50050h && currentTimeMillis <= i0Var2.f50051i) {
                            SkinManager.setBackgroundResource(this.q, R.drawable.orange_btn_selector);
                            this.q.setEnabled(true);
                        } else {
                            SkinManager.setBackgroundResource(this.q, R.drawable.btn_gift_give_d);
                            this.q.setEnabled(false);
                        }
                    } else {
                        SkinManager.setBackgroundResource(this.q, R.drawable.orange_btn_selector);
                        this.q.setEnabled(true);
                    }
                    int i4 = this.U.q;
                    this.m.setText(d.a.n0.v0.b.g.a((i4 >= 0 ? i4 : 0L) * d2, this.M, i3));
                    return (float) j2;
                }
                return (float) j2;
            }
            a2 = 0;
            j2 = a2 * d2;
            if (z) {
            }
        } else {
            j2 = 0;
            if (z) {
            }
        }
    }

    public final void z() {
        if (ListUtils.getCount(this.I) == 0 || ListUtils.getCount(this.H) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<d.a.n0.v0.b.a> it = this.I.iterator();
        while (it.hasNext()) {
            d.a.n0.v0.b.a next = it.next();
            if (next != null && (TextUtils.isEmpty(next.b()) || ListUtils.getCount(next.c()) == 0)) {
                arrayList.add(next);
                Iterator<d.a.n0.v0.b.c> it2 = this.H.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    d.a.n0.v0.b.c next2 = it2.next();
                    if (next2 != null && next2.a() == next.a()) {
                        arrayList2.add(next2);
                        break;
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.I.removeAll(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.H.removeAll(arrayList2);
        }
    }
}
