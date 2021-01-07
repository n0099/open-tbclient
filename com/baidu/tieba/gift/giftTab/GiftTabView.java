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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftPagerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    private String addFreeUrl;
    private ArrayList<com.baidu.tieba.gift.giftTab.c> bcC;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> bcD;
    private ArrayList<com.baidu.tieba.gift.giftTab.e> bcE;
    protected View bcL;
    protected HorizontalScrollView bcR;
    protected LinearLayout bcS;
    private int bdm;
    public int currencyType;
    protected FrameLayout jRi;
    protected View jRj;
    protected View jRk;
    protected EditText jRl;
    protected TextView jRm;
    protected TextView jRn;
    protected BaseViewPager jRo;
    protected IndicatorView jRp;
    protected View jRq;
    protected View jRs;
    protected ListView jRt;
    protected GiftPagerAdapter jRv;
    protected View jSA;
    protected TextView jSB;
    protected TextView jSC;
    protected ImageView jSD;
    protected TextView jSE;
    protected TextView jSF;
    protected TextView jSG;
    protected View jSH;
    protected FrameLayout jSI;
    protected com.baidu.tieba.gift.giftTab.d jSJ;
    protected com.baidu.tbadk.core.view.a jSK;
    private f jSL;
    private ah jSM;
    private int jSN;
    private int jSO;
    private int jSP;
    private View.OnClickListener jSi;
    private e jSk;
    private GiftTabActivity jSz;
    private View mRoot;
    public ai urlTitleData;
    protected List<View> bdb = new ArrayList();
    private int freeChance = 0;
    private int bdf = 0;
    private int bdg = 0;
    private int mSelectedPosition = 0;
    private int bdh = 0;
    private SparseIntArray bdn = new SparseIntArray();
    private SparseBooleanArray bdo = new SparseBooleanArray();
    private View.OnClickListener jSQ = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(GiftTabView.this.urlTitleData.eQx)) {
                be.bwv().b(GiftTabView.this.jSz.getPageContext(), new String[]{GiftTabView.this.urlTitleData.eQx});
            }
        }
    };
    private View.OnClickListener jSR = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
        }
    };
    Handler jSS = new Handler();
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.9
        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.cPK();
            GiftTabView.this.rL(true);
        }
    };
    boolean jST = false;

    /* loaded from: classes9.dex */
    public interface e {
        void Jh();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void CC(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.jSN = 0;
        this.jSO = 0;
        this.jSP = 0;
        this.jSz = giftTabActivity;
        this.jSi = onClickListener;
        this.mRoot = LayoutInflater.from(this.jSz.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.jSz.setContentView(this.mRoot);
        initViews();
        this.jSN = l.getStatusBarHeight(this.jSz.getActivity());
        this.jSO = l.getDimens(this.jSz.getActivity(), R.dimen.ds330);
        this.jSP = l.getDimens(this.jSz.getActivity(), R.dimen.ds10);
    }

    private void initViews() {
        this.jRi = (FrameLayout) this.mRoot.findViewById(R.id.gift_panel_lay);
        this.jRj = this.mRoot.findViewById(R.id.empty_layout);
        this.jRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftTabView.this.jRs.getVisibility() != 0) {
                    GiftTabView.this.jSz.closeActivity();
                } else {
                    GiftTabView.this.jRs.setVisibility(8);
                }
            }
        });
        this.bcL = this.mRoot.findViewById(R.id.gift_count_layout);
        this.bcL.setOnClickListener(this.jSR);
        this.jRk = this.mRoot.findViewById(R.id.gift_list_layout);
        this.jRl = (EditText) this.mRoot.findViewById(R.id.gift_count_input);
        this.jRl.setSelection(1);
        rJ(false);
        this.jRl.addTextChangedListener(new c());
        this.jRl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
                GiftTabView.this.jSz.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GiftTabView.this.rJ(false);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.jSO, -2);
                        int[] iArr = new int[2];
                        GiftTabView.this.jRl.getLocationOnScreen(iArr);
                        layoutParams.leftMargin = iArr[0] - GiftTabView.this.jSP;
                        int i = (iArr[1] - GiftTabView.this.jSN) - GiftTabView.this.jSP;
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            i += UtilHelper.getStatusBarHeight();
                        }
                        layoutParams.topMargin = i;
                        GiftTabView.this.jRt.setLayoutParams(layoutParams);
                        GiftTabView.this.jRs.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jRl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    l.showSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
                } else {
                    l.hideSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
                }
            }
        });
        this.jSA = this.mRoot.findViewById(R.id.reward_parent_view);
        this.jSB = (TextView) this.mRoot.findViewById(R.id.reward_count_result);
        this.jSC = (TextView) this.mRoot.findViewById(R.id.reward_jump);
        this.jSD = (ImageView) this.mRoot.findViewById(R.id.reward_jump_arrow);
        this.jSA.setOnClickListener(this.jSQ);
        this.jRm = (TextView) this.mRoot.findViewById(R.id.gift_count_result);
        this.jRn = (TextView) this.mRoot.findViewById(R.id.gift_button);
        this.jRn.setEnabled(false);
        this.jRn.setOnClickListener(this.jSi);
        this.jSE = (TextView) this.mRoot.findViewById(R.id.gift_desc_view);
        this.jSE.setOnClickListener(this.jSR);
        this.jSF = (TextView) this.mRoot.findViewById(R.id.get_free_chance_view);
        this.jSF.setOnClickListener(this.jSi);
        this.jSG = (TextView) this.mRoot.findViewById(R.id.text_view_gift_to);
        this.jSG.setOnClickListener(this.jSR);
        this.jRq = this.mRoot.findViewById(R.id.gift_lower_layout);
        this.jRo = (BaseViewPager) this.mRoot.findViewById(R.id.gift_viewpager);
        this.jRo.setOnPageChangeListener(this);
        this.jRp = (IndicatorView) this.mRoot.findViewById(R.id.gift_tab_indicator);
        this.bcS = (LinearLayout) this.mRoot.findViewById(R.id.gift_tab_layout);
        this.bcR = (HorizontalScrollView) this.mRoot.findViewById(R.id.gift_tab_scrollview);
        this.jRs = this.mRoot.findViewById(R.id.gift_num_layout);
        this.jRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftTabView.this.jRs.setVisibility(8);
                l.hideSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
            }
        });
        this.jRt = (ListView) this.mRoot.findViewById(R.id.gift_num_list);
        this.jRt.setOnItemClickListener(new b());
        this.jSI = (FrameLayout) this.mRoot.findViewById(R.id.tab_container_view);
        this.jSH = bS(false);
        this.jSH.setVisibility(8);
        this.jSI.addView(this.jSH);
    }

    public void a(boolean z, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<com.baidu.tieba.gift.giftTab.e> arrayList3) {
        this.bcC = arrayList;
        this.bcD = arrayList2;
        this.bcE = arrayList3;
        rK(z);
    }

    private void rK(boolean z) {
        IY();
        cPO();
        if (this.bcC == null || this.bcC.size() <= 0) {
            this.jRq.setVisibility(8);
            this.jSH.setVisibility(0);
            return;
        }
        this.jRn.setEnabled(true);
        this.jSH.setVisibility(8);
        this.jRq.setVisibility(0);
        if (z) {
            m(this.bcD);
            K(this.bcE);
        }
        c(this.bcC, z);
        cPL();
        cPM();
        rL(true);
    }

    private void IY() {
        if (x.getCount(this.bcD) != 0 && x.getCount(this.bcC) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.bcD.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || x.getCount(next.Ey()) == 0)) {
                    arrayList.add(next);
                    Iterator<com.baidu.tieba.gift.giftTab.c> it2 = this.bcC.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.baidu.tieba.gift.giftTab.c next2 = it2.next();
                        if (next2 != null && next2.getCategoryId() == next.getCategoryId()) {
                            arrayList2.add(next2);
                            break;
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.bcD.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.bcC.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, boolean z) {
        int i;
        List<ah> subList;
        if (arrayList != null) {
            this.bdn.clear();
            this.bdb.clear();
            this.jRo.setAdapter(null);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<ah> Hb = arrayList.get(i2).Hb();
                int size = Hb != null ? Hb.size() : 0;
                if (size <= 0) {
                    List<ah> arrayList2 = new ArrayList<>();
                    if (!this.bdo.get(i2)) {
                        this.bdb.add(h(arrayList2, -1));
                    } else {
                        this.bdb.add(bS(true));
                    }
                    i = 1;
                } else {
                    int ceil = (int) Math.ceil(size / 8.0d);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        if (i3 == ceil - 1) {
                            if (i3 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(Hb.get(size - 1));
                            } else {
                                subList = Hb.subList(i3 * 8, size);
                            }
                        } else {
                            subList = Hb.subList(i3 * 8, (i3 + 1) * 8);
                        }
                        if (i2 == 0 && i3 == 0 && z) {
                            this.bdb.add(h(subList, 0));
                            this.jSM = subList.get(0);
                        } else {
                            this.bdb.add(h(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.bdn.append(i2, i);
            }
            this.jRv = new GiftPagerAdapter(this.bdb);
            this.jRo.setAdapter(this.jRv);
            this.jRo.setCurrentItem(this.bdf);
            Jb();
        }
    }

    private View bS(boolean z) {
        View inflate = LayoutInflater.from(this.jSz.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.net_refresh_button);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource((TbImageView) inflate.findViewById(R.id.net_refresh_image), R.drawable.new_pic_emotion_08);
        ao.setViewTextColor((TextView) inflate.findViewById(R.id.net_refresh_title), R.color.CAM_X0105, 1, skinType);
        ao.setViewTextColor(textView, R.color.CAM_X0111, 1, skinType);
        ao.setBackgroundResource(textView, R.drawable.btn_appdownload, skinType);
        if (z) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jSL != null) {
                        GiftTabView.this.bdo.append(GiftTabView.this.bdh, true);
                        GiftTabView.this.jSL.CC(((com.baidu.tieba.gift.giftTab.c) GiftTabView.this.bcC.get(GiftTabView.this.bdh)).getCategoryId());
                    }
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jSk != null) {
                        GiftTabView.this.jSk.Jh();
                    }
                }
            });
        }
        return inflate;
    }

    private GridView h(List<ah> list, int i) {
        com.baidu.tieba.gift.giftTab.b bVar = new com.baidu.tieba.gift.giftTab.b(this.jSz.getPageContext().getPageActivity());
        bVar.setGiftItems(list);
        bVar.er(i);
        TableLineGridView tableLineGridView = new TableLineGridView(this.jSz.getPageContext().getPageActivity());
        tableLineGridView.setColumnCount(4);
        tableLineGridView.setRowCount(2);
        tableLineGridView.setBackgroundLineResource(ao.getColor(R.color.CAM_X0204));
        tableLineGridView.setVerticalScrollBarEnabled(false);
        tableLineGridView.setNumColumns(4);
        tableLineGridView.setSelector(R.color.common_color_10022);
        tableLineGridView.setAdapter((ListAdapter) bVar);
        tableLineGridView.setOnItemClickListener(new a());
        return tableLineGridView;
    }

    @SuppressLint({"ResourceAsColor"})
    private void m(ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList) {
        int i;
        if (arrayList != null && arrayList.size() > 0) {
            this.bcS.removeAllViews();
            int size = arrayList.size();
            int equipmentWidth = l.getEquipmentWidth(this.jSz.getPageContext().getPageActivity());
            if (size >= 5) {
                i = equipmentWidth / 5;
            } else {
                i = equipmentWidth / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.a aVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && aVar.Ey() != null && aVar.Ey().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.jSz.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                    textView.setText(aVar.getCategoryName());
                    linearLayout.setOnClickListener(new d(i2));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.bcS.addView(linearLayout, layoutParams);
                }
            }
            eE(this.bdh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.mPosition, GiftTabView.this.bdn.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = GiftTabView.this.bdn.get(i) + i2;
            }
            GiftTabView.this.bdf = i2;
            GiftTabView.this.jRo.setCurrentItem(GiftTabView.this.bdf);
            GiftTabView.this.Jb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c implements TextWatcher {
        private c() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i = com.baidu.adp.lib.f.b.toInt(editable.toString(), 0);
            if (editable.toString().length() == String.valueOf(i).length()) {
                GiftTabView.this.rL(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            GiftTabView.this.jRl.setText("" + i2);
            GiftTabView.this.jRl.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (GiftTabView.this.bcE == null || GiftTabView.this.bcE.size() <= 0) {
                GiftTabView.this.rJ(true);
                Selection.selectAll(GiftTabView.this.jRl.getText());
                GiftTabView.this.jRs.setVisibility(8);
                GiftTabView.this.rL(true);
                return;
            }
            if (i == GiftTabView.this.bcE.size()) {
                GiftTabView.this.rJ(true);
                Selection.selectAll(GiftTabView.this.jRl.getText());
            } else {
                GiftTabView.this.jRl.setCursorVisible(true);
                GiftTabView.this.jRl.setFocusable(true);
                com.baidu.tieba.gift.giftTab.e eVar = (com.baidu.tieba.gift.giftTab.e) GiftTabView.this.bcE.get(i);
                if (eVar != null) {
                    GiftTabView.this.jRl.setText("" + eVar.getNumber());
                }
            }
            GiftTabView.this.jRs.setVisibility(8);
            GiftTabView.this.rL(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rL(boolean z) {
        long j;
        if (this.jSM == null) {
            return 0L;
        }
        int i = com.baidu.adp.lib.f.b.toInt(this.jRl.getText().toString(), 0);
        this.bdm = i;
        int i2 = this.jSM.aKj;
        switch (i2) {
            case 3:
                j = (this.jSM.eQr >= 0 ? this.jSM.eQr : 0L) * i;
                break;
            case 4:
            default:
                j = (this.jSM.price >= 0 ? this.jSM.price : 0L) * i;
                break;
            case 5:
                j = 0;
                break;
        }
        if (z) {
            this.jRm.setText(g.l(j, true));
            if (i <= 0) {
                ao.setBackgroundResource(this.jRn, R.drawable.btn_gift_give_d);
                this.jRn.setEnabled(false);
            } else if (i2 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < this.jSM.beginTime || currentTimeMillis > this.jSM.endTime) {
                    ao.setBackgroundResource(this.jRn, R.drawable.btn_gift_give_d);
                    this.jRn.setEnabled(false);
                } else {
                    ao.setBackgroundResource(this.jRn, R.drawable.orange_btn_selector);
                    this.jRn.setEnabled(true);
                }
            } else {
                ao.setBackgroundResource(this.jRn, R.drawable.orange_btn_selector);
                this.jRn.setEnabled(true);
            }
            this.jSB.setText(g.C((this.jSM.eQv >= 0 ? this.jSM.eQv : 0L) * i, this.currencyType));
            return j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rJ(boolean z) {
        this.jRl.setCursorVisible(z);
        this.jRl.setFocusable(z);
        this.jRl.setFocusableInTouchMode(z);
        if (z) {
            this.jRl.requestFocus();
        } else {
            this.jRl.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GiftTabView.this.bdg = GiftTabView.this.bdf;
            GiftTabView.this.mSelectedPosition = i;
            l.hideSoftKeyPad(GiftTabView.this.jSz.getPageContext().getPageActivity(), GiftTabView.this.jRl);
            com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) adapterView.getAdapter();
            if (bVar != null) {
                ah item = bVar.getItem(i);
                if (item != null) {
                    GiftTabView.this.jSM = item;
                }
                bVar.er(i);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.cPL();
            GiftTabView.this.cPM();
            GiftTabView.this.rL(true);
        }
    }

    public void cPJ() {
        this.jSS.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPK() {
        String str;
        if (this.jSM != null && this.jSM.aKj == 1) {
            String str2 = null;
            String str3 = null;
            int i = this.jSM.aKj;
            if (!StringUtils.isNull(this.jSM.desc)) {
                str = "\"" + this.jSM.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.jSM.beginTime && currentTimeMillis < this.jSM.endTime) {
                j = (this.jSM.endTime - currentTimeMillis) * 1000;
                str3 = at.getTimeSpace(j);
                str2 = String.format(this.jSz.getPageContext().getString(R.string.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.jSM.beginTime) {
                j = (this.jSM.beginTime - currentTimeMillis) * 1000;
                str3 = at.getTimeSpace(j);
                str2 = String.format(this.jSz.getPageContext().getString(R.string.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.jSM.endTime) {
                str2 = this.jSz.getPageContext().getString(R.string.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, null));
            this.jSE.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jST = true;
                    this.jSS.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jST) {
                    this.jST = false;
                    this.jSS.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jSS.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPL() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPM() {
        String str;
        if (this.jSz.accountType == 1) {
            this.mRoot.findViewById(R.id.desc_parent_view).setVisibility(8);
        } else if (this.jSM != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i = this.jSM.aKj;
            if (!StringUtils.isNull(this.jSM.desc)) {
                str = "\"" + this.jSM.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (i) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.jSM.beginTime && currentTimeMillis < this.jSM.endTime) {
                        j = (this.jSM.endTime - currentTimeMillis) * 1000;
                        str3 = at.getTimeSpace(j);
                        str2 = String.format(this.jSz.getPageContext().getString(R.string.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.jSM.beginTime) {
                        j = (this.jSM.beginTime - currentTimeMillis) * 1000;
                        str3 = at.getTimeSpace(j);
                        str2 = String.format(this.jSz.getPageContext().getString(R.string.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.jSM.endTime) {
                        str2 = this.jSz.getPageContext().getString(R.string.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.jSz.getPageContext().getString(R.string.left_number), Integer.valueOf(this.jSM.aZh));
                    str3 = "" + this.jSM.aZh;
                    break;
                case 3:
                    str4 = String.format(this.jSz.getPageContext().getString(R.string.original_price), at.formatOverBaiwanNum(this.jSM.price));
                    str3 = String.format(this.jSz.getPageContext().getString(R.string.discount_price), at.formatOverBaiwanNum(this.jSM.eQr));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.jSz.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = "" + this.freeChance;
                        this.jRl.setText("" + this.freeChance);
                        break;
                    } else {
                        this.jRl.setText("0");
                        this.jRn.setEnabled(false);
                        str2 = this.jSz.getPageContext().getString(R.string.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (i == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.jSF.setVisibility(0);
            } else {
                this.jSF.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, str4));
            this.jSE.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jST = true;
                    this.jSS.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jST) {
                    this.jST = false;
                    this.jSS.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jSS.removeCallbacks(this.runnable);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bdf = i;
        Jb();
        if (i >= 0 && i < this.bdb.size() && (this.bdb.get(i) instanceof GridView)) {
            GridView gridView = (GridView) this.bdb.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) gridView.getAdapter();
                if (bVar.IA() >= 0 && i != this.bdg) {
                    bVar.er(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.IA() < 0 && i == this.bdg) {
                    bVar.er(this.mSelectedPosition);
                    bVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jb() {
        int i = 0;
        for (int i2 = 0; i2 < this.bdn.size(); i2++) {
            for (int i3 = 0; i3 < this.bdn.get(i2); i3++) {
                if (i + i3 == this.bdf) {
                    if (this.bdn.get(i2) <= 1) {
                        this.jRp.setVisibility(4);
                    } else {
                        this.jRp.setVisibility(0);
                    }
                    this.jRp.setCount(this.bdn.get(i2));
                    this.jRp.setPosition(i3);
                    eE(i2);
                    return;
                }
            }
            i += this.bdn.get(i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void eE(int i) {
        int childCount = this.bcS.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                LinearLayout linearLayout = (LinearLayout) this.bcS.getChildAt(i2);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                View findViewById = linearLayout.findViewById(R.id.text_divider_line);
                if (i2 != i) {
                    ao.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                    ao.setBackgroundColor(findViewById, R.color.common_color_10022);
                    textView.setEnabled(true);
                    findViewById.setEnabled(true);
                } else {
                    ao.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                    ao.setBackgroundColor(findViewById, R.color.gift_tab_textcolor_selected);
                    textView.setEnabled(false);
                    findViewById.setEnabled(false);
                    eF(i);
                    this.bdh = i;
                    this.bcR.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    private void eF(int i) {
        int childCount = this.bcS.getChildCount();
        if (i >= 0 && i < childCount && this.bcC != null && this.bcC.size() > i && this.bcC.get(i) != null && !this.bdo.get(i)) {
            if ((this.bcC.get(i).Hb() == null || this.bcC.get(i).Hb().size() <= 0) && this.jSL != null) {
                this.bdo.append(i, true);
                this.jSL.CC(this.bcC.get(i).getCategoryId());
            }
        }
    }

    private void K(List<com.baidu.tieba.gift.giftTab.e> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.baidu.tieba.gift.giftTab.e eVar : list) {
                if (eVar.getNumber() <= 0) {
                    arrayList.add(eVar);
                }
            }
            list.removeAll(arrayList);
        }
        this.jSJ = new com.baidu.tieba.gift.giftTab.d(this.jSz.getPageContext().getPageActivity());
        this.jRt.setAdapter((ListAdapter) this.jSJ);
        this.jSJ.J(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.jSz.getPageContext(), this.jRk);
        ao.setBackgroundResource(this.jRt, R.drawable.chx_box_im_gift);
        if (this.jSJ != null) {
            this.jSJ.notifyDataSetChanged();
        }
        this.jRp.setSelector(ao.getDrawable(R.drawable.point_live_s));
        this.jRp.setDrawable(ao.getDrawable(R.drawable.point_live_n));
    }

    public void cPN() {
        if (this.jSK == null) {
            this.jSK = new com.baidu.tbadk.core.view.a(this.jSz.getPageContext());
        }
        this.jSK.setDialogVisiable(true);
    }

    public void cPO() {
        if (this.jSK != null) {
            this.jSK.setDialogVisiable(false);
        }
    }

    public void CF(int i) {
        this.freeChance = i;
        cPL();
        if (this.jSM != null && this.jSM.aKj == 5) {
            cPM();
        }
    }

    public void a(f fVar) {
        this.jSL = fVar;
    }

    public void a(e eVar) {
        this.jSk = eVar;
    }

    public void LQ(String str) {
        this.addFreeUrl = str;
    }

    public int Jd() {
        return this.bdm;
    }

    public ah cPP() {
        return this.jSM;
    }
}
