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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
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
    private ArrayList<com.baidu.tieba.gift.giftTab.c> baV;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> baW;
    private ArrayList<com.baidu.tieba.gift.giftTab.e> baX;
    private int bbF;
    protected View bbe;
    protected HorizontalScrollView bbk;
    protected LinearLayout bbl;
    public int currencyType;
    protected FrameLayout jUf;
    protected View jUg;
    protected View jUh;
    protected EditText jUi;
    protected TextView jUj;
    protected TextView jUk;
    protected BaseViewPager jUl;
    protected IndicatorView jUm;
    protected View jUn;
    protected View jUp;
    protected ListView jUq;
    protected GiftPagerAdapter jUs;
    protected ImageView jVA;
    protected TextView jVB;
    protected TextView jVC;
    protected TextView jVD;
    protected View jVE;
    protected FrameLayout jVF;
    protected com.baidu.tieba.gift.giftTab.d jVG;
    protected com.baidu.tbadk.core.view.a jVH;
    private f jVI;
    private ai jVJ;
    private int jVK;
    private int jVL;
    private int jVM;
    private View.OnClickListener jVf;
    private e jVh;
    private GiftTabActivity jVw;
    protected View jVx;
    protected TextView jVy;
    protected TextView jVz;
    private View mRoot;
    public aj urlTitleData;
    protected List<View> bbu = new ArrayList();
    private int freeChance = 0;
    private int bby = 0;
    private int bbz = 0;
    private int mSelectedPosition = 0;
    private int bbA = 0;
    private SparseIntArray bbG = new SparseIntArray();
    private SparseBooleanArray bbH = new SparseBooleanArray();
    private View.OnClickListener jVN = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(GiftTabView.this.urlTitleData.eNY)) {
                bf.bsV().b(GiftTabView.this.jVw.getPageContext(), new String[]{GiftTabView.this.urlTitleData.eNY});
            }
        }
    };
    private View.OnClickListener jVO = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
        }
    };
    Handler jVP = new Handler();
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.9
        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.cNP();
            GiftTabView.this.rS(true);
        }
    };
    boolean jVQ = false;

    /* loaded from: classes9.dex */
    public interface e {
        void GC();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void Bl(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.jVK = 0;
        this.jVL = 0;
        this.jVM = 0;
        this.jVw = giftTabActivity;
        this.jVf = onClickListener;
        this.mRoot = LayoutInflater.from(this.jVw.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.jVw.setContentView(this.mRoot);
        initViews();
        this.jVK = l.getStatusBarHeight(this.jVw.getActivity());
        this.jVL = l.getDimens(this.jVw.getActivity(), R.dimen.ds330);
        this.jVM = l.getDimens(this.jVw.getActivity(), R.dimen.ds10);
    }

    private void initViews() {
        this.jUf = (FrameLayout) this.mRoot.findViewById(R.id.gift_panel_lay);
        this.jUg = this.mRoot.findViewById(R.id.empty_layout);
        this.jUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftTabView.this.jUp.getVisibility() != 0) {
                    GiftTabView.this.jVw.closeActivity();
                } else {
                    GiftTabView.this.jUp.setVisibility(8);
                }
            }
        });
        this.bbe = this.mRoot.findViewById(R.id.gift_count_layout);
        this.bbe.setOnClickListener(this.jVO);
        this.jUh = this.mRoot.findViewById(R.id.gift_list_layout);
        this.jUi = (EditText) this.mRoot.findViewById(R.id.gift_count_input);
        this.jUi.setSelection(1);
        rQ(false);
        this.jUi.addTextChangedListener(new c());
        this.jUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
                GiftTabView.this.jVw.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GiftTabView.this.rQ(false);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.jVL, -2);
                        int[] iArr = new int[2];
                        GiftTabView.this.jUi.getLocationOnScreen(iArr);
                        layoutParams.leftMargin = iArr[0] - GiftTabView.this.jVM;
                        int i = (iArr[1] - GiftTabView.this.jVK) - GiftTabView.this.jVM;
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            i += UtilHelper.getStatusBarHeight();
                        }
                        layoutParams.topMargin = i;
                        GiftTabView.this.jUq.setLayoutParams(layoutParams);
                        GiftTabView.this.jUp.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jUi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    l.showSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
                } else {
                    l.hideSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
                }
            }
        });
        this.jVx = this.mRoot.findViewById(R.id.reward_parent_view);
        this.jVy = (TextView) this.mRoot.findViewById(R.id.reward_count_result);
        this.jVz = (TextView) this.mRoot.findViewById(R.id.reward_jump);
        this.jVA = (ImageView) this.mRoot.findViewById(R.id.reward_jump_arrow);
        this.jVx.setOnClickListener(this.jVN);
        this.jUj = (TextView) this.mRoot.findViewById(R.id.gift_count_result);
        this.jUk = (TextView) this.mRoot.findViewById(R.id.gift_button);
        this.jUk.setEnabled(false);
        this.jUk.setOnClickListener(this.jVf);
        this.jVB = (TextView) this.mRoot.findViewById(R.id.gift_desc_view);
        this.jVB.setOnClickListener(this.jVO);
        this.jVC = (TextView) this.mRoot.findViewById(R.id.get_free_chance_view);
        this.jVC.setOnClickListener(this.jVf);
        this.jVD = (TextView) this.mRoot.findViewById(R.id.text_view_gift_to);
        this.jVD.setOnClickListener(this.jVO);
        this.jUn = this.mRoot.findViewById(R.id.gift_lower_layout);
        this.jUl = (BaseViewPager) this.mRoot.findViewById(R.id.gift_viewpager);
        this.jUl.setOnPageChangeListener(this);
        this.jUm = (IndicatorView) this.mRoot.findViewById(R.id.gift_tab_indicator);
        this.bbl = (LinearLayout) this.mRoot.findViewById(R.id.gift_tab_layout);
        this.bbk = (HorizontalScrollView) this.mRoot.findViewById(R.id.gift_tab_scrollview);
        this.jUp = this.mRoot.findViewById(R.id.gift_num_layout);
        this.jUp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftTabView.this.jUp.setVisibility(8);
                l.hideSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
            }
        });
        this.jUq = (ListView) this.mRoot.findViewById(R.id.gift_num_list);
        this.jUq.setOnItemClickListener(new b());
        this.jVF = (FrameLayout) this.mRoot.findViewById(R.id.tab_container_view);
        this.jVE = bT(false);
        this.jVE.setVisibility(8);
        this.jVF.addView(this.jVE);
    }

    public void a(boolean z, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<com.baidu.tieba.gift.giftTab.e> arrayList3) {
        this.baV = arrayList;
        this.baW = arrayList2;
        this.baX = arrayList3;
        rR(z);
    }

    private void rR(boolean z) {
        Gt();
        cNT();
        if (this.baV == null || this.baV.size() <= 0) {
            this.jUn.setVisibility(8);
            this.jVE.setVisibility(0);
            return;
        }
        this.jUk.setEnabled(true);
        this.jVE.setVisibility(8);
        this.jUn.setVisibility(0);
        if (z) {
            h(this.baW);
            K(this.baX);
        }
        c(this.baV, z);
        cNQ();
        cNR();
        rS(true);
    }

    private void Gt() {
        if (y.getCount(this.baW) != 0 && y.getCount(this.baV) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.baW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || y.getCount(next.Bn()) == 0)) {
                    arrayList.add(next);
                    Iterator<com.baidu.tieba.gift.giftTab.c> it2 = this.baV.iterator();
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
                this.baW.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.baV.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, boolean z) {
        int i;
        List<ai> subList;
        if (arrayList != null) {
            this.bbG.clear();
            this.bbu.clear();
            this.jUl.setAdapter(null);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<ai> Ew = arrayList.get(i2).Ew();
                int size = Ew != null ? Ew.size() : 0;
                if (size <= 0) {
                    List<ai> arrayList2 = new ArrayList<>();
                    if (!this.bbH.get(i2)) {
                        this.bbu.add(h(arrayList2, -1));
                    } else {
                        this.bbu.add(bT(true));
                    }
                    i = 1;
                } else {
                    int ceil = (int) Math.ceil(size / 8.0d);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        if (i3 == ceil - 1) {
                            if (i3 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(Ew.get(size - 1));
                            } else {
                                subList = Ew.subList(i3 * 8, size);
                            }
                        } else {
                            subList = Ew.subList(i3 * 8, (i3 + 1) * 8);
                        }
                        if (i2 == 0 && i3 == 0 && z) {
                            this.bbu.add(h(subList, 0));
                            this.jVJ = subList.get(0);
                        } else {
                            this.bbu.add(h(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.bbG.append(i2, i);
            }
            this.jUs = new GiftPagerAdapter(this.bbu);
            this.jUl.setAdapter(this.jUs);
            this.jUl.setCurrentItem(this.bby);
            Gw();
        }
    }

    private View bT(boolean z) {
        View inflate = LayoutInflater.from(this.jVw.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.net_refresh_button);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource((TbImageView) inflate.findViewById(R.id.net_refresh_image), R.drawable.new_pic_emotion_08);
        ap.setViewTextColor((TextView) inflate.findViewById(R.id.net_refresh_title), R.color.CAM_X0105, 1, skinType);
        ap.setViewTextColor(textView, R.color.CAM_X0111, 1, skinType);
        ap.setBackgroundResource(textView, R.drawable.btn_appdownload, skinType);
        if (z) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jVI != null) {
                        GiftTabView.this.bbH.append(GiftTabView.this.bbA, true);
                        GiftTabView.this.jVI.Bl(((com.baidu.tieba.gift.giftTab.c) GiftTabView.this.baV.get(GiftTabView.this.bbA)).getCategoryId());
                    }
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jVh != null) {
                        GiftTabView.this.jVh.GC();
                    }
                }
            });
        }
        return inflate;
    }

    private GridView h(List<ai> list, int i) {
        com.baidu.tieba.gift.giftTab.b bVar = new com.baidu.tieba.gift.giftTab.b(this.jVw.getPageContext().getPageActivity());
        bVar.setGiftItems(list);
        bVar.cQ(i);
        TableLineGridView tableLineGridView = new TableLineGridView(this.jVw.getPageContext().getPageActivity());
        tableLineGridView.setColumnCount(4);
        tableLineGridView.setRowCount(2);
        tableLineGridView.setBackgroundLineResource(ap.getColor(R.color.CAM_X0204));
        tableLineGridView.setVerticalScrollBarEnabled(false);
        tableLineGridView.setNumColumns(4);
        tableLineGridView.setSelector(R.color.common_color_10022);
        tableLineGridView.setAdapter((ListAdapter) bVar);
        tableLineGridView.setOnItemClickListener(new a());
        return tableLineGridView;
    }

    @SuppressLint({"ResourceAsColor"})
    private void h(ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList) {
        int i;
        if (arrayList != null && arrayList.size() > 0) {
            this.bbl.removeAllViews();
            int size = arrayList.size();
            int equipmentWidth = l.getEquipmentWidth(this.jVw.getPageContext().getPageActivity());
            if (size >= 5) {
                i = equipmentWidth / 5;
            } else {
                i = equipmentWidth / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.a aVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && aVar.Bn() != null && aVar.Bn().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.jVw.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                    textView.setText(aVar.getCategoryName());
                    linearLayout.setOnClickListener(new d(i2));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.bbl.addView(linearLayout, layoutParams);
                }
            }
            dd(this.bbA);
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
            int min = Math.min(this.mPosition, GiftTabView.this.bbG.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = GiftTabView.this.bbG.get(i) + i2;
            }
            GiftTabView.this.bby = i2;
            GiftTabView.this.jUl.setCurrentItem(GiftTabView.this.bby);
            GiftTabView.this.Gw();
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
                GiftTabView.this.rS(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            GiftTabView.this.jUi.setText("" + i2);
            GiftTabView.this.jUi.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (GiftTabView.this.baX == null || GiftTabView.this.baX.size() <= 0) {
                GiftTabView.this.rQ(true);
                Selection.selectAll(GiftTabView.this.jUi.getText());
                GiftTabView.this.jUp.setVisibility(8);
                GiftTabView.this.rS(true);
                return;
            }
            if (i == GiftTabView.this.baX.size()) {
                GiftTabView.this.rQ(true);
                Selection.selectAll(GiftTabView.this.jUi.getText());
            } else {
                GiftTabView.this.jUi.setCursorVisible(true);
                GiftTabView.this.jUi.setFocusable(true);
                com.baidu.tieba.gift.giftTab.e eVar = (com.baidu.tieba.gift.giftTab.e) GiftTabView.this.baX.get(i);
                if (eVar != null) {
                    GiftTabView.this.jUi.setText("" + eVar.getNumber());
                }
            }
            GiftTabView.this.jUp.setVisibility(8);
            GiftTabView.this.rS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rS(boolean z) {
        long j;
        if (this.jVJ == null) {
            return 0L;
        }
        int i = com.baidu.adp.lib.f.b.toInt(this.jUi.getText().toString(), 0);
        this.bbF = i;
        int i2 = this.jVJ.aHS;
        switch (i2) {
            case 3:
                j = (this.jVJ.eNS >= 0 ? this.jVJ.eNS : 0L) * i;
                break;
            case 4:
            default:
                j = (this.jVJ.price >= 0 ? this.jVJ.price : 0L) * i;
                break;
            case 5:
                j = 0;
                break;
        }
        if (z) {
            this.jUj.setText(g.m(j, true));
            if (i <= 0) {
                ap.setBackgroundResource(this.jUk, R.drawable.btn_gift_give_d);
                this.jUk.setEnabled(false);
            } else if (i2 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < this.jVJ.beginTime || currentTimeMillis > this.jVJ.endTime) {
                    ap.setBackgroundResource(this.jUk, R.drawable.btn_gift_give_d);
                    this.jUk.setEnabled(false);
                } else {
                    ap.setBackgroundResource(this.jUk, R.drawable.orange_btn_selector);
                    this.jUk.setEnabled(true);
                }
            } else {
                ap.setBackgroundResource(this.jUk, R.drawable.orange_btn_selector);
                this.jUk.setEnabled(true);
            }
            this.jVy.setText(g.A((this.jVJ.eNW >= 0 ? this.jVJ.eNW : 0L) * i, this.currencyType));
            return j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        this.jUi.setCursorVisible(z);
        this.jUi.setFocusable(z);
        this.jUi.setFocusableInTouchMode(z);
        if (z) {
            this.jUi.requestFocus();
        } else {
            this.jUi.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GiftTabView.this.bbz = GiftTabView.this.bby;
            GiftTabView.this.mSelectedPosition = i;
            l.hideSoftKeyPad(GiftTabView.this.jVw.getPageContext().getPageActivity(), GiftTabView.this.jUi);
            com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) adapterView.getAdapter();
            if (bVar != null) {
                ai item = bVar.getItem(i);
                if (item != null) {
                    GiftTabView.this.jVJ = item;
                }
                bVar.cQ(i);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.cNQ();
            GiftTabView.this.cNR();
            GiftTabView.this.rS(true);
        }
    }

    public void cNO() {
        this.jVP.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNP() {
        String str;
        if (this.jVJ != null && this.jVJ.aHS == 1) {
            String str2 = null;
            String str3 = null;
            int i = this.jVJ.aHS;
            if (!StringUtils.isNull(this.jVJ.desc)) {
                str = "\"" + this.jVJ.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.jVJ.beginTime && currentTimeMillis < this.jVJ.endTime) {
                j = (this.jVJ.endTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jVw.getPageContext().getString(R.string.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.jVJ.beginTime) {
                j = (this.jVJ.beginTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jVw.getPageContext().getString(R.string.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.jVJ.endTime) {
                str2 = this.jVw.getPageContext().getString(R.string.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, null));
            this.jVB.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jVQ = true;
                    this.jVP.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jVQ) {
                    this.jVQ = false;
                    this.jVP.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jVP.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNR() {
        String str;
        if (this.jVw.accountType == 1) {
            this.mRoot.findViewById(R.id.desc_parent_view).setVisibility(8);
        } else if (this.jVJ != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i = this.jVJ.aHS;
            if (!StringUtils.isNull(this.jVJ.desc)) {
                str = "\"" + this.jVJ.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (i) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.jVJ.beginTime && currentTimeMillis < this.jVJ.endTime) {
                        j = (this.jVJ.endTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jVw.getPageContext().getString(R.string.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.jVJ.beginTime) {
                        j = (this.jVJ.beginTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jVw.getPageContext().getString(R.string.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.jVJ.endTime) {
                        str2 = this.jVw.getPageContext().getString(R.string.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.jVw.getPageContext().getString(R.string.left_number), Integer.valueOf(this.jVJ.aXz));
                    str3 = "" + this.jVJ.aXz;
                    break;
                case 3:
                    str4 = String.format(this.jVw.getPageContext().getString(R.string.original_price), au.formatOverBaiwanNum(this.jVJ.price));
                    str3 = String.format(this.jVw.getPageContext().getString(R.string.discount_price), au.formatOverBaiwanNum(this.jVJ.eNS));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.jVw.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = "" + this.freeChance;
                        this.jUi.setText("" + this.freeChance);
                        break;
                    } else {
                        this.jUi.setText("0");
                        this.jUk.setEnabled(false);
                        str2 = this.jVw.getPageContext().getString(R.string.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (i == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.jVC.setVisibility(0);
            } else {
                this.jVC.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, str4));
            this.jVB.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jVQ = true;
                    this.jVP.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jVQ) {
                    this.jVQ = false;
                    this.jVP.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jVP.removeCallbacks(this.runnable);
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
        this.bby = i;
        Gw();
        if (i >= 0 && i < this.bbu.size() && (this.bbu.get(i) instanceof GridView)) {
            GridView gridView = (GridView) this.bbu.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) gridView.getAdapter();
                if (bVar.FV() >= 0 && i != this.bbz) {
                    bVar.cQ(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.FV() < 0 && i == this.bbz) {
                    bVar.cQ(this.mSelectedPosition);
                    bVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gw() {
        int i = 0;
        for (int i2 = 0; i2 < this.bbG.size(); i2++) {
            for (int i3 = 0; i3 < this.bbG.get(i2); i3++) {
                if (i + i3 == this.bby) {
                    if (this.bbG.get(i2) <= 1) {
                        this.jUm.setVisibility(4);
                    } else {
                        this.jUm.setVisibility(0);
                    }
                    this.jUm.setCount(this.bbG.get(i2));
                    this.jUm.setPosition(i3);
                    dd(i2);
                    return;
                }
            }
            i += this.bbG.get(i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void dd(int i) {
        int childCount = this.bbl.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                LinearLayout linearLayout = (LinearLayout) this.bbl.getChildAt(i2);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                View findViewById = linearLayout.findViewById(R.id.text_divider_line);
                if (i2 != i) {
                    ap.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                    ap.setBackgroundColor(findViewById, R.color.common_color_10022);
                    textView.setEnabled(true);
                    findViewById.setEnabled(true);
                } else {
                    ap.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                    ap.setBackgroundColor(findViewById, R.color.gift_tab_textcolor_selected);
                    textView.setEnabled(false);
                    findViewById.setEnabled(false);
                    de(i);
                    this.bbA = i;
                    this.bbk.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    private void de(int i) {
        int childCount = this.bbl.getChildCount();
        if (i >= 0 && i < childCount && this.baV != null && this.baV.size() > i && this.baV.get(i) != null && !this.bbH.get(i)) {
            if ((this.baV.get(i).Ew() == null || this.baV.get(i).Ew().size() <= 0) && this.jVI != null) {
                this.bbH.append(i, true);
                this.jVI.Bl(this.baV.get(i).getCategoryId());
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
        this.jVG = new com.baidu.tieba.gift.giftTab.d(this.jVw.getPageContext().getPageActivity());
        this.jUq.setAdapter((ListAdapter) this.jVG);
        this.jVG.J(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.jVw.getPageContext(), this.jUh);
        ap.setBackgroundResource(this.jUq, R.drawable.chx_box_im_gift);
        if (this.jVG != null) {
            this.jVG.notifyDataSetChanged();
        }
        this.jUm.setSelector(ap.getDrawable(R.drawable.point_live_s));
        this.jUm.setDrawable(ap.getDrawable(R.drawable.point_live_n));
    }

    public void cNS() {
        if (this.jVH == null) {
            this.jVH = new com.baidu.tbadk.core.view.a(this.jVw.getPageContext());
        }
        this.jVH.setDialogVisiable(true);
    }

    public void cNT() {
        if (this.jVH != null) {
            this.jVH.setDialogVisiable(false);
        }
    }

    public void Bo(int i) {
        this.freeChance = i;
        cNQ();
        if (this.jVJ != null && this.jVJ.aHS == 5) {
            cNR();
        }
    }

    public void a(f fVar) {
        this.jVI = fVar;
    }

    public void a(e eVar) {
        this.jVh = eVar;
    }

    public void Lw(String str) {
        this.addFreeUrl = str;
    }

    public int Gy() {
        return this.bbF;
    }

    public ai cNU() {
        return this.jVJ;
    }
}
