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
    protected IndicatorView jUA;
    protected View jUB;
    protected View jUD;
    protected ListView jUE;
    protected GiftPagerAdapter jUG;
    protected FrameLayout jUt;
    protected View jUu;
    protected View jUv;
    protected EditText jUw;
    protected TextView jUx;
    protected TextView jUy;
    protected BaseViewPager jUz;
    private GiftTabActivity jVK;
    protected View jVL;
    protected TextView jVM;
    protected TextView jVN;
    protected ImageView jVO;
    protected TextView jVP;
    protected TextView jVQ;
    protected TextView jVR;
    protected View jVS;
    protected FrameLayout jVT;
    protected com.baidu.tieba.gift.giftTab.d jVU;
    protected com.baidu.tbadk.core.view.a jVV;
    private f jVW;
    private ai jVX;
    private int jVY;
    private int jVZ;
    private View.OnClickListener jVt;
    private e jVv;
    private int jWa;
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
    private View.OnClickListener jWb = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(GiftTabView.this.urlTitleData.eNY)) {
                bf.bsV().b(GiftTabView.this.jVK.getPageContext(), new String[]{GiftTabView.this.urlTitleData.eNY});
            }
        }
    };
    private View.OnClickListener jWc = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
        }
    };
    Handler jWd = new Handler();
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.9
        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.cNW();
            GiftTabView.this.rS(true);
        }
    };
    boolean jWe = false;

    /* loaded from: classes9.dex */
    public interface e {
        void GC();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void Bl(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.jVY = 0;
        this.jVZ = 0;
        this.jWa = 0;
        this.jVK = giftTabActivity;
        this.jVt = onClickListener;
        this.mRoot = LayoutInflater.from(this.jVK.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.jVK.setContentView(this.mRoot);
        initViews();
        this.jVY = l.getStatusBarHeight(this.jVK.getActivity());
        this.jVZ = l.getDimens(this.jVK.getActivity(), R.dimen.ds330);
        this.jWa = l.getDimens(this.jVK.getActivity(), R.dimen.ds10);
    }

    private void initViews() {
        this.jUt = (FrameLayout) this.mRoot.findViewById(R.id.gift_panel_lay);
        this.jUu = this.mRoot.findViewById(R.id.empty_layout);
        this.jUu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftTabView.this.jUD.getVisibility() != 0) {
                    GiftTabView.this.jVK.closeActivity();
                } else {
                    GiftTabView.this.jUD.setVisibility(8);
                }
            }
        });
        this.bbe = this.mRoot.findViewById(R.id.gift_count_layout);
        this.bbe.setOnClickListener(this.jWc);
        this.jUv = this.mRoot.findViewById(R.id.gift_list_layout);
        this.jUw = (EditText) this.mRoot.findViewById(R.id.gift_count_input);
        this.jUw.setSelection(1);
        rQ(false);
        this.jUw.addTextChangedListener(new c());
        this.jUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
                GiftTabView.this.jVK.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GiftTabView.this.rQ(false);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.jVZ, -2);
                        int[] iArr = new int[2];
                        GiftTabView.this.jUw.getLocationOnScreen(iArr);
                        layoutParams.leftMargin = iArr[0] - GiftTabView.this.jWa;
                        int i = (iArr[1] - GiftTabView.this.jVY) - GiftTabView.this.jWa;
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            i += UtilHelper.getStatusBarHeight();
                        }
                        layoutParams.topMargin = i;
                        GiftTabView.this.jUE.setLayoutParams(layoutParams);
                        GiftTabView.this.jUD.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jUw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    l.showSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
                } else {
                    l.hideSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
                }
            }
        });
        this.jVL = this.mRoot.findViewById(R.id.reward_parent_view);
        this.jVM = (TextView) this.mRoot.findViewById(R.id.reward_count_result);
        this.jVN = (TextView) this.mRoot.findViewById(R.id.reward_jump);
        this.jVO = (ImageView) this.mRoot.findViewById(R.id.reward_jump_arrow);
        this.jVL.setOnClickListener(this.jWb);
        this.jUx = (TextView) this.mRoot.findViewById(R.id.gift_count_result);
        this.jUy = (TextView) this.mRoot.findViewById(R.id.gift_button);
        this.jUy.setEnabled(false);
        this.jUy.setOnClickListener(this.jVt);
        this.jVP = (TextView) this.mRoot.findViewById(R.id.gift_desc_view);
        this.jVP.setOnClickListener(this.jWc);
        this.jVQ = (TextView) this.mRoot.findViewById(R.id.get_free_chance_view);
        this.jVQ.setOnClickListener(this.jVt);
        this.jVR = (TextView) this.mRoot.findViewById(R.id.text_view_gift_to);
        this.jVR.setOnClickListener(this.jWc);
        this.jUB = this.mRoot.findViewById(R.id.gift_lower_layout);
        this.jUz = (BaseViewPager) this.mRoot.findViewById(R.id.gift_viewpager);
        this.jUz.setOnPageChangeListener(this);
        this.jUA = (IndicatorView) this.mRoot.findViewById(R.id.gift_tab_indicator);
        this.bbl = (LinearLayout) this.mRoot.findViewById(R.id.gift_tab_layout);
        this.bbk = (HorizontalScrollView) this.mRoot.findViewById(R.id.gift_tab_scrollview);
        this.jUD = this.mRoot.findViewById(R.id.gift_num_layout);
        this.jUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftTabView.this.jUD.setVisibility(8);
                l.hideSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
            }
        });
        this.jUE = (ListView) this.mRoot.findViewById(R.id.gift_num_list);
        this.jUE.setOnItemClickListener(new b());
        this.jVT = (FrameLayout) this.mRoot.findViewById(R.id.tab_container_view);
        this.jVS = bT(false);
        this.jVS.setVisibility(8);
        this.jVT.addView(this.jVS);
    }

    public void a(boolean z, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<com.baidu.tieba.gift.giftTab.e> arrayList3) {
        this.baV = arrayList;
        this.baW = arrayList2;
        this.baX = arrayList3;
        rR(z);
    }

    private void rR(boolean z) {
        Gt();
        cOa();
        if (this.baV == null || this.baV.size() <= 0) {
            this.jUB.setVisibility(8);
            this.jVS.setVisibility(0);
            return;
        }
        this.jUy.setEnabled(true);
        this.jVS.setVisibility(8);
        this.jUB.setVisibility(0);
        if (z) {
            h(this.baW);
            K(this.baX);
        }
        c(this.baV, z);
        cNX();
        cNY();
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
            this.jUz.setAdapter(null);
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
                            this.jVX = subList.get(0);
                        } else {
                            this.bbu.add(h(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.bbG.append(i2, i);
            }
            this.jUG = new GiftPagerAdapter(this.bbu);
            this.jUz.setAdapter(this.jUG);
            this.jUz.setCurrentItem(this.bby);
            Gw();
        }
    }

    private View bT(boolean z) {
        View inflate = LayoutInflater.from(this.jVK.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
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
                    if (GiftTabView.this.jVW != null) {
                        GiftTabView.this.bbH.append(GiftTabView.this.bbA, true);
                        GiftTabView.this.jVW.Bl(((com.baidu.tieba.gift.giftTab.c) GiftTabView.this.baV.get(GiftTabView.this.bbA)).getCategoryId());
                    }
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jVv != null) {
                        GiftTabView.this.jVv.GC();
                    }
                }
            });
        }
        return inflate;
    }

    private GridView h(List<ai> list, int i) {
        com.baidu.tieba.gift.giftTab.b bVar = new com.baidu.tieba.gift.giftTab.b(this.jVK.getPageContext().getPageActivity());
        bVar.setGiftItems(list);
        bVar.cQ(i);
        TableLineGridView tableLineGridView = new TableLineGridView(this.jVK.getPageContext().getPageActivity());
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
            int equipmentWidth = l.getEquipmentWidth(this.jVK.getPageContext().getPageActivity());
            if (size >= 5) {
                i = equipmentWidth / 5;
            } else {
                i = equipmentWidth / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.a aVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && aVar.Bn() != null && aVar.Bn().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.jVK.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
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
            GiftTabView.this.jUz.setCurrentItem(GiftTabView.this.bby);
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
            GiftTabView.this.jUw.setText("" + i2);
            GiftTabView.this.jUw.setSelection(String.valueOf(i2).length());
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
                Selection.selectAll(GiftTabView.this.jUw.getText());
                GiftTabView.this.jUD.setVisibility(8);
                GiftTabView.this.rS(true);
                return;
            }
            if (i == GiftTabView.this.baX.size()) {
                GiftTabView.this.rQ(true);
                Selection.selectAll(GiftTabView.this.jUw.getText());
            } else {
                GiftTabView.this.jUw.setCursorVisible(true);
                GiftTabView.this.jUw.setFocusable(true);
                com.baidu.tieba.gift.giftTab.e eVar = (com.baidu.tieba.gift.giftTab.e) GiftTabView.this.baX.get(i);
                if (eVar != null) {
                    GiftTabView.this.jUw.setText("" + eVar.getNumber());
                }
            }
            GiftTabView.this.jUD.setVisibility(8);
            GiftTabView.this.rS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rS(boolean z) {
        long j;
        if (this.jVX == null) {
            return 0L;
        }
        int i = com.baidu.adp.lib.f.b.toInt(this.jUw.getText().toString(), 0);
        this.bbF = i;
        int i2 = this.jVX.aHS;
        switch (i2) {
            case 3:
                j = (this.jVX.eNS >= 0 ? this.jVX.eNS : 0L) * i;
                break;
            case 4:
            default:
                j = (this.jVX.price >= 0 ? this.jVX.price : 0L) * i;
                break;
            case 5:
                j = 0;
                break;
        }
        if (z) {
            this.jUx.setText(g.m(j, true));
            if (i <= 0) {
                ap.setBackgroundResource(this.jUy, R.drawable.btn_gift_give_d);
                this.jUy.setEnabled(false);
            } else if (i2 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < this.jVX.beginTime || currentTimeMillis > this.jVX.endTime) {
                    ap.setBackgroundResource(this.jUy, R.drawable.btn_gift_give_d);
                    this.jUy.setEnabled(false);
                } else {
                    ap.setBackgroundResource(this.jUy, R.drawable.orange_btn_selector);
                    this.jUy.setEnabled(true);
                }
            } else {
                ap.setBackgroundResource(this.jUy, R.drawable.orange_btn_selector);
                this.jUy.setEnabled(true);
            }
            this.jVM.setText(g.A((this.jVX.eNW >= 0 ? this.jVX.eNW : 0L) * i, this.currencyType));
            return j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        this.jUw.setCursorVisible(z);
        this.jUw.setFocusable(z);
        this.jUw.setFocusableInTouchMode(z);
        if (z) {
            this.jUw.requestFocus();
        } else {
            this.jUw.clearFocus();
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
            l.hideSoftKeyPad(GiftTabView.this.jVK.getPageContext().getPageActivity(), GiftTabView.this.jUw);
            com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) adapterView.getAdapter();
            if (bVar != null) {
                ai item = bVar.getItem(i);
                if (item != null) {
                    GiftTabView.this.jVX = item;
                }
                bVar.cQ(i);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.cNX();
            GiftTabView.this.cNY();
            GiftTabView.this.rS(true);
        }
    }

    public void cNV() {
        this.jWd.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNW() {
        String str;
        if (this.jVX != null && this.jVX.aHS == 1) {
            String str2 = null;
            String str3 = null;
            int i = this.jVX.aHS;
            if (!StringUtils.isNull(this.jVX.desc)) {
                str = "\"" + this.jVX.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.jVX.beginTime && currentTimeMillis < this.jVX.endTime) {
                j = (this.jVX.endTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jVK.getPageContext().getString(R.string.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.jVX.beginTime) {
                j = (this.jVX.beginTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jVK.getPageContext().getString(R.string.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.jVX.endTime) {
                str2 = this.jVK.getPageContext().getString(R.string.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, null));
            this.jVP.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jWe = true;
                    this.jWd.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jWe) {
                    this.jWe = false;
                    this.jWd.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jWd.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNX() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNY() {
        String str;
        if (this.jVK.accountType == 1) {
            this.mRoot.findViewById(R.id.desc_parent_view).setVisibility(8);
        } else if (this.jVX != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i = this.jVX.aHS;
            if (!StringUtils.isNull(this.jVX.desc)) {
                str = "\"" + this.jVX.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (i) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.jVX.beginTime && currentTimeMillis < this.jVX.endTime) {
                        j = (this.jVX.endTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jVK.getPageContext().getString(R.string.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.jVX.beginTime) {
                        j = (this.jVX.beginTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jVK.getPageContext().getString(R.string.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.jVX.endTime) {
                        str2 = this.jVK.getPageContext().getString(R.string.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.jVK.getPageContext().getString(R.string.left_number), Integer.valueOf(this.jVX.aXz));
                    str3 = "" + this.jVX.aXz;
                    break;
                case 3:
                    str4 = String.format(this.jVK.getPageContext().getString(R.string.original_price), au.formatOverBaiwanNum(this.jVX.price));
                    str3 = String.format(this.jVK.getPageContext().getString(R.string.discount_price), au.formatOverBaiwanNum(this.jVX.eNS));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.jVK.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = "" + this.freeChance;
                        this.jUw.setText("" + this.freeChance);
                        break;
                    } else {
                        this.jUw.setText("0");
                        this.jUy.setEnabled(false);
                        str2 = this.jVK.getPageContext().getString(R.string.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (i == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.jVQ.setVisibility(0);
            } else {
                this.jVQ.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, str4));
            this.jVP.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jWe = true;
                    this.jWd.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jWe) {
                    this.jWe = false;
                    this.jWd.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jWd.removeCallbacks(this.runnable);
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
                        this.jUA.setVisibility(4);
                    } else {
                        this.jUA.setVisibility(0);
                    }
                    this.jUA.setCount(this.bbG.get(i2));
                    this.jUA.setPosition(i3);
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
            if ((this.baV.get(i).Ew() == null || this.baV.get(i).Ew().size() <= 0) && this.jVW != null) {
                this.bbH.append(i, true);
                this.jVW.Bl(this.baV.get(i).getCategoryId());
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
        this.jVU = new com.baidu.tieba.gift.giftTab.d(this.jVK.getPageContext().getPageActivity());
        this.jUE.setAdapter((ListAdapter) this.jVU);
        this.jVU.J(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.jVK.getPageContext(), this.jUv);
        ap.setBackgroundResource(this.jUE, R.drawable.chx_box_im_gift);
        if (this.jVU != null) {
            this.jVU.notifyDataSetChanged();
        }
        this.jUA.setSelector(ap.getDrawable(R.drawable.point_live_s));
        this.jUA.setDrawable(ap.getDrawable(R.drawable.point_live_n));
    }

    public void cNZ() {
        if (this.jVV == null) {
            this.jVV = new com.baidu.tbadk.core.view.a(this.jVK.getPageContext());
        }
        this.jVV.setDialogVisiable(true);
    }

    public void cOa() {
        if (this.jVV != null) {
            this.jVV.setDialogVisiable(false);
        }
    }

    public void Bo(int i) {
        this.freeChance = i;
        cNX();
        if (this.jVX != null && this.jVX.aHS == 5) {
            cNY();
        }
    }

    public void a(f fVar) {
        this.jVW = fVar;
    }

    public void a(e eVar) {
        this.jVv = eVar;
    }

    public void Lx(String str) {
        this.addFreeUrl = str;
    }

    public int Gy() {
        return this.bbF;
    }

    public ai cOb() {
        return this.jVX;
    }
}
