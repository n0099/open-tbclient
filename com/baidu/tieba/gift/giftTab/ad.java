package com.baidu.tieba.gift.giftTab;

import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad implements ViewPager.OnPageChangeListener {
    private String addFreeUrl;
    protected FrameLayout bud;
    protected View bue;
    protected View buf;
    protected EditText bug;
    protected TextView buh;
    protected TextView bui;
    protected BaseViewPager buj;
    protected IndicatorView buk;
    protected LinearLayout bul;
    protected View bum;
    protected View buo;
    protected ListView bup;
    protected com.baidu.tieba.gift.buyGift.s bus;
    private ArrayList<k> bvA;
    private GiftTabActivity bvG;
    protected View bvH;
    protected TextView bvI;
    protected TextView bvJ;
    protected TextView bvK;
    protected HorizontalScrollView bvL;
    protected View bvM;
    protected FrameLayout bvN;
    protected j bvO;
    protected com.baidu.tbadk.core.view.b bvP;
    private f bvQ;
    private com.baidu.tbadk.core.data.l bvS;
    private int bvU;
    private int bvV;
    private int bvW;
    private int bvX;
    private View.OnClickListener bvm;
    private e bvo;
    private ArrayList<i> bvy;
    private ArrayList<com.baidu.tieba.gift.giftTab.c> bvz;
    private View mRoot;
    protected List<View> buq = new ArrayList();
    private int freeChance = 0;
    private int bhi = 0;
    private int buu = 0;
    private int buv = 0;
    private int bvR = 0;
    private SparseIntArray bux = new SparseIntArray();
    private SparseBooleanArray bvT = new SparseBooleanArray();
    private View.OnClickListener bvY = new ae(this);
    Handler bvZ = new Handler();
    Runnable IR = new af(this);
    boolean bwa = false;

    /* loaded from: classes.dex */
    public interface e {
        void Tf();
    }

    /* loaded from: classes.dex */
    public interface f {
        void hv(int i);
    }

    public ad(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.bvU = 0;
        this.bvV = 0;
        this.bvW = 0;
        this.bvG = giftTabActivity;
        this.bvm = onClickListener;
        this.mRoot = LayoutInflater.from(this.bvG.getPageContext().getPageActivity()).inflate(n.g.gift_tab_activity, (ViewGroup) null);
        this.bvG.setContentView(this.mRoot);
        initViews();
        this.bvU = com.baidu.adp.lib.util.k.l(this.bvG.getActivity());
        this.bvV = com.baidu.adp.lib.util.k.d(this.bvG.getActivity(), n.d.ds330);
        this.bvW = com.baidu.adp.lib.util.k.d(this.bvG.getActivity(), n.d.ds10);
    }

    private void initViews() {
        this.bud = (FrameLayout) this.mRoot.findViewById(n.f.gift_panel_lay);
        this.bue = this.mRoot.findViewById(n.f.empty_layout);
        this.bue.setOnClickListener(new ag(this));
        this.bvH = this.mRoot.findViewById(n.f.gift_count_layout);
        this.bvH.setOnClickListener(this.bvY);
        this.buf = this.mRoot.findViewById(n.f.gift_list_layout);
        this.bug = (EditText) this.mRoot.findViewById(n.f.gift_count_input);
        this.bug.setSelection(1);
        cR(false);
        this.bug.addTextChangedListener(new c(this, null));
        this.bug.setOnClickListener(new ah(this));
        this.bug.setOnFocusChangeListener(new aj(this));
        this.buh = (TextView) this.mRoot.findViewById(n.f.gift_count_result);
        this.bui = (TextView) this.mRoot.findViewById(n.f.gift_button);
        this.bui.setEnabled(false);
        this.bui.setOnClickListener(this.bvm);
        this.bvI = (TextView) this.mRoot.findViewById(n.f.gift_desc_view);
        this.bvI.setOnClickListener(this.bvY);
        this.bvJ = (TextView) this.mRoot.findViewById(n.f.get_free_chance_view);
        this.bvJ.setOnClickListener(this.bvm);
        this.bvK = (TextView) this.mRoot.findViewById(n.f.text_view_gift_to);
        this.bvK.setOnClickListener(this.bvY);
        this.bum = this.mRoot.findViewById(n.f.gift_lower_layout);
        this.buj = (BaseViewPager) this.mRoot.findViewById(n.f.gift_viewpager);
        this.buj.setOnPageChangeListener(this);
        this.buk = (IndicatorView) this.mRoot.findViewById(n.f.gift_tab_indicator);
        this.bul = (LinearLayout) this.mRoot.findViewById(n.f.gift_tab_layout);
        this.bvL = (HorizontalScrollView) this.mRoot.findViewById(n.f.gift_tab_scrollview);
        this.buo = this.mRoot.findViewById(n.f.gift_num_layout);
        this.buo.setOnClickListener(new ak(this));
        this.bup = (ListView) this.mRoot.findViewById(n.f.gift_num_list);
        this.bup.setOnItemClickListener(new b(this, null));
        this.bvN = (FrameLayout) this.mRoot.findViewById(n.f.tab_container_view);
        this.bvM = cT(false);
        this.bvM.setVisibility(8);
        this.bvN.addView(this.bvM);
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList2, ArrayList<k> arrayList3) {
        this.bvy = arrayList;
        this.bvz = arrayList2;
        this.bvA = arrayList3;
        cS(z);
    }

    private void cS(boolean z) {
        Tm();
        if (this.bvy == null || this.bvy.size() <= 0) {
            this.bum.setVisibility(8);
            this.bvM.setVisibility(0);
            return;
        }
        this.bui.setEnabled(true);
        this.bvM.setVisibility(8);
        this.bum.setVisibility(0);
        if (z) {
            H(this.bvz);
            aJ(this.bvA);
        }
        d(this.bvy, z);
        Tk();
        cU(true);
    }

    private void d(ArrayList<i> arrayList, boolean z) {
        int i;
        List<com.baidu.tbadk.core.data.l> subList;
        if (arrayList != null) {
            this.bux.clear();
            this.buq.clear();
            this.buj.setAdapter(null);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<com.baidu.tbadk.core.data.l> Td = arrayList.get(i2).Td();
                int size = Td != null ? Td.size() : 0;
                if (size <= 0) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!this.bvT.get(i2)) {
                        this.buq.add(e(arrayList2, -1));
                        i = 1;
                    } else {
                        this.buq.add(cT(true));
                        i = 1;
                    }
                } else {
                    int ceil = (int) Math.ceil(size / 8.0d);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        if (i3 == ceil - 1) {
                            if (i3 * 8 == size - 1) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(Td.get(size - 1));
                                subList = arrayList3;
                            } else {
                                subList = Td.subList(i3 * 8, size);
                            }
                        } else {
                            subList = Td.subList(i3 * 8, (i3 + 1) * 8);
                        }
                        if (i2 == 0 && i3 == 0 && z) {
                            this.buq.add(e(subList, 0));
                            this.bvS = subList.get(0);
                        } else {
                            this.buq.add(e(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.bux.append(i2, i);
            }
            this.bus = new com.baidu.tieba.gift.buyGift.s(this.buq);
            this.buj.setAdapter(this.bus);
            this.buj.setCurrentItem(this.bhi);
            Ta();
        }
    }

    private View cT(boolean z) {
        View inflate = LayoutInflater.from(this.bvG.getPageContext().getPageActivity()).inflate(n.g.gift_nodata_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(n.f.net_refresh_button);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        as.c((TbImageView) inflate.findViewById(n.f.net_refresh_image), n.e.net_refresh_emotion);
        as.a((TextView) inflate.findViewById(n.f.net_refresh_title), n.c.cp_cont_b, 1, skinType);
        as.a(textView, n.c.cp_cont_g, 1, skinType);
        as.c(textView, n.e.btn_appdownload, skinType);
        if (z) {
            textView.setOnClickListener(new al(this));
        } else {
            textView.setOnClickListener(new am(this));
        }
        return inflate;
    }

    private GridView e(List<com.baidu.tbadk.core.data.l> list, int i) {
        h hVar = new h(this.bvG.getPageContext().getPageActivity());
        hVar.setGiftItems(list);
        hVar.hq(i);
        an anVar = new an(this.bvG.getPageContext().getPageActivity());
        anVar.setColumnCount(4);
        anVar.setRowCount(2);
        anVar.setBackgroundLineResource(as.getColor(n.c.cp_bg_line_b));
        anVar.setVerticalScrollBarEnabled(false);
        anVar.setNumColumns(4);
        anVar.setSelector(n.c.transparent);
        anVar.setAdapter((ListAdapter) hVar);
        anVar.setOnItemClickListener(new a(this, null));
        return anVar;
    }

    private void H(ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList) {
        int i;
        if (arrayList != null && arrayList.size() > 0) {
            this.bul.removeAllViews();
            int size = arrayList.size();
            int K = com.baidu.adp.lib.util.k.K(this.bvG.getPageContext().getPageActivity());
            if (size >= 5) {
                i = K / 5;
            } else {
                i = K / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.c cVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(cVar.getCategoryName()) && cVar.Tc() != null && cVar.Tc().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.bvG.getPageContext().getPageActivity()).inflate(n.g.gift_tab_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(n.f.text_view);
                    textView.setText(cVar.getCategoryName());
                    linearLayout.setOnClickListener(new d(i2));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.bul.addView(linearLayout, layoutParams);
                }
            }
            hp(this.bvR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private int apI;

        public d(int i) {
            this.apI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.apI, ad.this.bux.size());
            int i = 0;
            for (int i2 = 0; i2 < min; i2++) {
                i += ad.this.bux.get(i2);
            }
            ad.this.bhi = i;
            ad.this.buj.setCurrentItem(ad.this.bhi);
            ad.this.Ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        private c() {
        }

        /* synthetic */ c(ad adVar, c cVar) {
            this();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v2 int)] */
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int g = com.baidu.adp.lib.h.b.g(editable.toString(), 0);
            if (editable.toString().length() != String.valueOf(g).length()) {
                int i = g >= 0 ? g : 0;
                ad.this.bug.setText(new StringBuilder().append(i).toString());
                ad.this.bug.setSelection(String.valueOf(i).length());
                return;
            }
            ad.this.cU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        /* synthetic */ b(ad adVar, b bVar) {
            this();
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0082: INVOKE  (r0v23 int A[REMOVE]) = (r0v22 com.baidu.tieba.gift.giftTab.k) type: VIRTUAL call: com.baidu.tieba.gift.giftTab.k.Te():int)] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (ad.this.bvA != null && ad.this.bvA.size() > 0) {
                if (i != ad.this.bvA.size()) {
                    ad.this.bug.setCursorVisible(true);
                    ad.this.bug.setFocusable(true);
                    k kVar = (k) ad.this.bvA.get(i);
                    if (kVar != null) {
                        ad.this.bug.setText(new StringBuilder().append(kVar.Te()).toString());
                    }
                } else {
                    ad.this.cR(true);
                    Selection.selectAll(ad.this.bug.getText());
                }
                ad.this.buo.setVisibility(8);
                ad.this.cU(true);
                return;
            }
            ad.this.cR(true);
            Selection.selectAll(ad.this.bug.getText());
            ad.this.buo.setVisibility(8);
            ad.this.cU(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cU(boolean z) {
        if (this.bvS != null) {
            int g = com.baidu.adp.lib.h.b.g(this.bug.getText().toString(), 0);
            this.bvX = g;
            int rS = this.bvS.rS();
            switch (rS) {
                case 3:
                    r0 = (this.bvS.rV() >= 0 ? this.bvS.rV() : 0L) * g;
                    break;
                case 4:
                default:
                    r0 = (this.bvS.rR() >= 0 ? this.bvS.rR() : 0L) * g;
                    break;
                case 5:
                    break;
            }
            if (z) {
                this.buh.setText(ao.d(r0, true));
                if (g <= 0) {
                    as.i((View) this.bui, n.e.btn_gift_give_d);
                    this.bui.setEnabled(false);
                } else if (rS == 1) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis < this.bvS.rU() || currentTimeMillis > this.bvS.getEndTime()) {
                        as.i((View) this.bui, n.e.btn_gift_give_d);
                        this.bui.setEnabled(false);
                    } else {
                        as.i((View) this.bui, n.e.orange_btn_selector);
                        this.bui.setEnabled(true);
                    }
                } else {
                    as.i((View) this.bui, n.e.orange_btn_selector);
                    this.bui.setEnabled(true);
                }
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        this.bug.setCursorVisible(z);
        this.bug.setFocusable(z);
        this.bug.setFocusableInTouchMode(z);
        if (z) {
            this.bug.requestFocus();
        } else {
            this.bug.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        /* synthetic */ a(ad adVar, a aVar) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ad.this.buu = ad.this.bhi;
            ad.this.buv = i;
            com.baidu.adp.lib.util.k.c(ad.this.bvG.getPageContext().getPageActivity(), ad.this.bug);
            h hVar = (h) adapterView.getAdapter();
            if (hVar != null) {
                com.baidu.tbadk.core.data.l item = hVar.getItem(i);
                if (item != null) {
                    ad.this.bvS = item;
                }
                hVar.hq(i);
                hVar.notifyDataSetChanged();
            }
            ad.this.Tk();
            ad.this.cU(true);
        }
    }

    public void Ti() {
        this.bvZ.removeCallbacks(this.IR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tj() {
        String str;
        if (this.bvS != null && this.bvS.rS() == 1) {
            String str2 = null;
            String str3 = null;
            int rS = this.bvS.rS();
            if (!StringUtils.isNull(this.bvS.getDesc())) {
                str = "\"" + this.bvS.getDesc() + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.bvS.rU() && currentTimeMillis < this.bvS.getEndTime()) {
                j = (this.bvS.getEndTime() - currentTimeMillis) * 1000;
                str3 = ax.t(j);
                str2 = String.format(this.bvG.getPageContext().getString(n.i.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.bvS.rU()) {
                j = (this.bvS.rU() - currentTimeMillis) * 1000;
                str3 = ax.t(j);
                str2 = String.format(this.bvG.getPageContext().getString(n.i.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.bvS.getEndTime()) {
                str2 = this.bvG.getPageContext().getString(n.i.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_cont_d)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) ao.s(str2, str3, null));
            this.bvI.setText(spannableStringBuilder);
            if (rS == 1) {
                if (j > 0 && j <= 3600000) {
                    this.bwa = true;
                    this.bvZ.postDelayed(this.IR, 1000L);
                    return;
                } else if (this.bwa) {
                    this.bwa = false;
                    this.bvZ.postDelayed(this.IR, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.bvZ.removeCallbacks(this.IR);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0152: INVOKE  (r7v14 int A[REMOVE]) = 
      (wrap: com.baidu.tbadk.core.data.l : 0x0150: IGET  (r7v13 com.baidu.tbadk.core.data.l A[REMOVE]) = (r12v0 'this' com.baidu.tieba.gift.giftTab.ad A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.gift.giftTab.ad.bvS com.baidu.tbadk.core.data.l)
     type: VIRTUAL call: com.baidu.tbadk.core.data.l.rW():int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01e4: IGET  (r7v4 int A[REMOVE]) = (r12v0 'this' com.baidu.tieba.gift.giftTab.ad A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.gift.giftTab.ad.freeChance int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01f5: IGET  (r9v0 int A[REMOVE]) = (r12v0 'this' com.baidu.tieba.gift.giftTab.ad A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.gift.giftTab.ad.freeChance int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void Tk() {
        String str;
        if (this.bvS != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int rS = this.bvS.rS();
            if (!StringUtils.isNull(this.bvS.getDesc())) {
                str = "\"" + this.bvS.getDesc() + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (rS) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.bvS.rU() && currentTimeMillis < this.bvS.getEndTime()) {
                        j = (this.bvS.getEndTime() - currentTimeMillis) * 1000;
                        str3 = ax.t(j);
                        str2 = String.format(this.bvG.getPageContext().getString(n.i.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.bvS.rU()) {
                        j = (this.bvS.rU() - currentTimeMillis) * 1000;
                        str3 = ax.t(j);
                        str2 = String.format(this.bvG.getPageContext().getString(n.i.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.bvS.getEndTime()) {
                        str2 = this.bvG.getPageContext().getString(n.i.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.bvG.getPageContext().getString(n.i.left_number), Integer.valueOf(this.bvS.rW()));
                    str3 = new StringBuilder().append(this.bvS.rW()).toString();
                    break;
                case 3:
                    str4 = String.format(this.bvG.getPageContext().getString(n.i.original_price), ax.A(this.bvS.rR()));
                    str3 = String.format(this.bvG.getPageContext().getString(n.i.discount_price), ax.A(this.bvS.rV()));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.bvG.getPageContext().getString(n.i.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = new StringBuilder().append(this.freeChance).toString();
                        this.bug.setText(new StringBuilder().append(this.freeChance).toString());
                        break;
                    } else {
                        this.bug.setText("0");
                        this.bui.setEnabled(false);
                        str2 = this.bvG.getPageContext().getString(n.i.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (rS == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.bvJ.setVisibility(0);
            } else {
                this.bvJ.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(as.getColor(n.c.cp_cont_d)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) ao.s(str2, str3, str4));
            this.bvI.setText(spannableStringBuilder);
            if (rS == 1) {
                if (j > 0 && j <= 3600000) {
                    this.bwa = true;
                    this.bvZ.postDelayed(this.IR, 1000L);
                    return;
                } else if (this.bwa) {
                    this.bwa = false;
                    this.bvZ.postDelayed(this.IR, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.bvZ.removeCallbacks(this.IR);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bhi = i;
        Ta();
        if (i >= 0 && i < this.buq.size() && (this.buq.get(i) instanceof GridView)) {
            GridView gridView = (GridView) this.buq.get(i);
            if (gridView.getAdapter() != null) {
                h hVar = (h) gridView.getAdapter();
                if (hVar.Tb() >= 0 && i != this.buu) {
                    hVar.hq(-1);
                    hVar.notifyDataSetChanged();
                }
                if (hVar.Tb() < 0 && i == this.buu) {
                    hVar.hq(this.buv);
                    hVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        int i = 0;
        for (int i2 = 0; i2 < this.bux.size(); i2++) {
            for (int i3 = 0; i3 < this.bux.get(i2); i3++) {
                if (i + i3 == this.bhi) {
                    if (this.bux.get(i2) <= 1) {
                        this.buk.setVisibility(4);
                    } else {
                        this.buk.setVisibility(0);
                    }
                    this.buk.setCount(this.bux.get(i2));
                    this.buk.setPosition(i3);
                    hp(i2);
                    return;
                }
            }
            i += this.bux.get(i2);
        }
    }

    private void hp(int i) {
        int childCount = this.bul.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                LinearLayout linearLayout = (LinearLayout) this.bul.getChildAt(i2);
                TextView textView = (TextView) linearLayout.findViewById(n.f.text_view);
                View findViewById = linearLayout.findViewById(n.f.text_divider_line);
                if (i2 != i) {
                    as.b(textView, n.c.gift_tab_textcolor_normal, 1);
                    as.j(findViewById, n.c.transparent);
                    textView.setEnabled(true);
                    findViewById.setEnabled(true);
                } else {
                    as.b(textView, n.c.gift_tab_textcolor_selected, 1);
                    as.j(findViewById, n.c.gift_tab_textcolor_selected);
                    textView.setEnabled(false);
                    findViewById.setEnabled(false);
                    hy(i);
                    this.bvR = i;
                    this.bvL.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    private void hy(int i) {
        int childCount = this.bul.getChildCount();
        if (i >= 0 && i < childCount && this.bvy != null && this.bvy.size() > i && this.bvy.get(i) != null && !this.bvT.get(i)) {
            if ((this.bvy.get(i).Td() == null || this.bvy.get(i).Td().size() <= 0) && this.bvQ != null) {
                this.bvT.append(i, true);
                this.bvQ.hv(this.bvy.get(i).getCategoryId());
            }
        }
    }

    private void aJ(List<k> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (k kVar : list) {
                if (kVar.Te() <= 0) {
                    arrayList.add(kVar);
                }
            }
            list.removeAll(arrayList);
        }
        this.bvO = new j(this.bvG.getPageContext().getPageActivity());
        this.bup.setAdapter((ListAdapter) this.bvO);
        this.bvO.aK(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.i.a.a(this.bvG.getPageContext(), this.buf);
        as.i(this.bup, n.e.chx_box_im_gift);
        if (this.bvO != null) {
            this.bvO.notifyDataSetChanged();
        }
        this.buk.setSelector(as.getDrawable(n.e.point_live_s));
        this.buk.setDrawable(as.getDrawable(n.e.point_live_n));
    }

    public void Tl() {
        if (this.bvP == null) {
            this.bvP = new com.baidu.tbadk.core.view.b(this.bvG.getPageContext());
        }
        this.bvP.ay(true);
    }

    public void Tm() {
        if (this.bvP != null) {
            this.bvP.ay(false);
        }
    }

    public void hz(int i) {
        this.freeChance = i;
        if (this.bvS != null && this.bvS.rS() == 5) {
            Tk();
        }
    }

    public void a(f fVar) {
        this.bvQ = fVar;
    }

    public void a(e eVar) {
        this.bvo = eVar;
    }

    public void hK(String str) {
        this.addFreeUrl = str;
    }

    public int Tn() {
        return this.bvX;
    }

    public com.baidu.tbadk.core.data.l To() {
        return this.bvS;
    }
}
