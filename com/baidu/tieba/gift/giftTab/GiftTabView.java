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
/* loaded from: classes8.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    private String addFreeUrl;
    protected View bcE;
    protected HorizontalScrollView bcK;
    protected LinearLayout bcL;
    private ArrayList<com.baidu.tieba.gift.giftTab.c> bcv;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> bcw;
    private ArrayList<com.baidu.tieba.gift.giftTab.e> bcx;
    private int bdf;
    public int currencyType;
    protected TextView jWA;
    protected BaseViewPager jWB;
    protected IndicatorView jWC;
    protected View jWD;
    protected View jWF;
    protected ListView jWG;
    protected GiftPagerAdapter jWI;
    protected FrameLayout jWv;
    protected View jWw;
    protected View jWx;
    protected EditText jWy;
    protected TextView jWz;
    private GiftTabActivity jXM;
    protected View jXN;
    protected TextView jXO;
    protected TextView jXP;
    protected ImageView jXQ;
    protected TextView jXR;
    protected TextView jXS;
    protected TextView jXT;
    protected View jXU;
    protected FrameLayout jXV;
    protected com.baidu.tieba.gift.giftTab.d jXW;
    protected com.baidu.tbadk.core.view.a jXX;
    private f jXY;
    private ai jXZ;
    private View.OnClickListener jXv;
    private e jXx;
    private int jYa;
    private int jYb;
    private int jYc;
    private View mRoot;
    public aj urlTitleData;
    protected List<View> bcU = new ArrayList();
    private int freeChance = 0;
    private int bcY = 0;
    private int bcZ = 0;
    private int mSelectedPosition = 0;
    private int bda = 0;
    private SparseIntArray bdg = new SparseIntArray();
    private SparseBooleanArray bdh = new SparseBooleanArray();
    private View.OnClickListener jYd = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(GiftTabView.this.urlTitleData.ePz)) {
                bf.bsY().b(GiftTabView.this.jXM.getPageContext(), new String[]{GiftTabView.this.urlTitleData.ePz});
            }
        }
    };
    private View.OnClickListener jYe = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
        }
    };
    Handler jYf = new Handler();
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.9
        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.cOd();
            GiftTabView.this.rS(true);
        }
    };
    boolean jYg = false;

    /* loaded from: classes8.dex */
    public interface e {
        void GF();
    }

    /* loaded from: classes8.dex */
    public interface f {
        void Bo(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.jYa = 0;
        this.jYb = 0;
        this.jYc = 0;
        this.jXM = giftTabActivity;
        this.jXv = onClickListener;
        this.mRoot = LayoutInflater.from(this.jXM.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.jXM.setContentView(this.mRoot);
        initViews();
        this.jYa = l.getStatusBarHeight(this.jXM.getActivity());
        this.jYb = l.getDimens(this.jXM.getActivity(), R.dimen.ds330);
        this.jYc = l.getDimens(this.jXM.getActivity(), R.dimen.ds10);
    }

    private void initViews() {
        this.jWv = (FrameLayout) this.mRoot.findViewById(R.id.gift_panel_lay);
        this.jWw = this.mRoot.findViewById(R.id.empty_layout);
        this.jWw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftTabView.this.jWF.getVisibility() != 0) {
                    GiftTabView.this.jXM.closeActivity();
                } else {
                    GiftTabView.this.jWF.setVisibility(8);
                }
            }
        });
        this.bcE = this.mRoot.findViewById(R.id.gift_count_layout);
        this.bcE.setOnClickListener(this.jYe);
        this.jWx = this.mRoot.findViewById(R.id.gift_list_layout);
        this.jWy = (EditText) this.mRoot.findViewById(R.id.gift_count_input);
        this.jWy.setSelection(1);
        rQ(false);
        this.jWy.addTextChangedListener(new c());
        this.jWy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
                GiftTabView.this.jXM.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GiftTabView.this.rQ(false);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.jYb, -2);
                        int[] iArr = new int[2];
                        GiftTabView.this.jWy.getLocationOnScreen(iArr);
                        layoutParams.leftMargin = iArr[0] - GiftTabView.this.jYc;
                        int i = (iArr[1] - GiftTabView.this.jYa) - GiftTabView.this.jYc;
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            i += UtilHelper.getStatusBarHeight();
                        }
                        layoutParams.topMargin = i;
                        GiftTabView.this.jWG.setLayoutParams(layoutParams);
                        GiftTabView.this.jWF.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jWy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    l.showSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
                } else {
                    l.hideSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
                }
            }
        });
        this.jXN = this.mRoot.findViewById(R.id.reward_parent_view);
        this.jXO = (TextView) this.mRoot.findViewById(R.id.reward_count_result);
        this.jXP = (TextView) this.mRoot.findViewById(R.id.reward_jump);
        this.jXQ = (ImageView) this.mRoot.findViewById(R.id.reward_jump_arrow);
        this.jXN.setOnClickListener(this.jYd);
        this.jWz = (TextView) this.mRoot.findViewById(R.id.gift_count_result);
        this.jWA = (TextView) this.mRoot.findViewById(R.id.gift_button);
        this.jWA.setEnabled(false);
        this.jWA.setOnClickListener(this.jXv);
        this.jXR = (TextView) this.mRoot.findViewById(R.id.gift_desc_view);
        this.jXR.setOnClickListener(this.jYe);
        this.jXS = (TextView) this.mRoot.findViewById(R.id.get_free_chance_view);
        this.jXS.setOnClickListener(this.jXv);
        this.jXT = (TextView) this.mRoot.findViewById(R.id.text_view_gift_to);
        this.jXT.setOnClickListener(this.jYe);
        this.jWD = this.mRoot.findViewById(R.id.gift_lower_layout);
        this.jWB = (BaseViewPager) this.mRoot.findViewById(R.id.gift_viewpager);
        this.jWB.setOnPageChangeListener(this);
        this.jWC = (IndicatorView) this.mRoot.findViewById(R.id.gift_tab_indicator);
        this.bcL = (LinearLayout) this.mRoot.findViewById(R.id.gift_tab_layout);
        this.bcK = (HorizontalScrollView) this.mRoot.findViewById(R.id.gift_tab_scrollview);
        this.jWF = this.mRoot.findViewById(R.id.gift_num_layout);
        this.jWF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftTabView.this.jWF.setVisibility(8);
                l.hideSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
            }
        });
        this.jWG = (ListView) this.mRoot.findViewById(R.id.gift_num_list);
        this.jWG.setOnItemClickListener(new b());
        this.jXV = (FrameLayout) this.mRoot.findViewById(R.id.tab_container_view);
        this.jXU = bT(false);
        this.jXU.setVisibility(8);
        this.jXV.addView(this.jXU);
    }

    public void a(boolean z, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<com.baidu.tieba.gift.giftTab.e> arrayList3) {
        this.bcv = arrayList;
        this.bcw = arrayList2;
        this.bcx = arrayList3;
        rR(z);
    }

    private void rR(boolean z) {
        Gw();
        cOh();
        if (this.bcv == null || this.bcv.size() <= 0) {
            this.jWD.setVisibility(8);
            this.jXU.setVisibility(0);
            return;
        }
        this.jWA.setEnabled(true);
        this.jXU.setVisibility(8);
        this.jWD.setVisibility(0);
        if (z) {
            h(this.bcw);
            K(this.bcx);
        }
        c(this.bcv, z);
        cOe();
        cOf();
        rS(true);
    }

    private void Gw() {
        if (y.getCount(this.bcw) != 0 && y.getCount(this.bcv) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.bcw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || y.getCount(next.Bq()) == 0)) {
                    arrayList.add(next);
                    Iterator<com.baidu.tieba.gift.giftTab.c> it2 = this.bcv.iterator();
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
                this.bcw.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.bcv.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, boolean z) {
        int i;
        List<ai> subList;
        if (arrayList != null) {
            this.bdg.clear();
            this.bcU.clear();
            this.jWB.setAdapter(null);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<ai> Ez = arrayList.get(i2).Ez();
                int size = Ez != null ? Ez.size() : 0;
                if (size <= 0) {
                    List<ai> arrayList2 = new ArrayList<>();
                    if (!this.bdh.get(i2)) {
                        this.bcU.add(h(arrayList2, -1));
                    } else {
                        this.bcU.add(bT(true));
                    }
                    i = 1;
                } else {
                    int ceil = (int) Math.ceil(size / 8.0d);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        if (i3 == ceil - 1) {
                            if (i3 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(Ez.get(size - 1));
                            } else {
                                subList = Ez.subList(i3 * 8, size);
                            }
                        } else {
                            subList = Ez.subList(i3 * 8, (i3 + 1) * 8);
                        }
                        if (i2 == 0 && i3 == 0 && z) {
                            this.bcU.add(h(subList, 0));
                            this.jXZ = subList.get(0);
                        } else {
                            this.bcU.add(h(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.bdg.append(i2, i);
            }
            this.jWI = new GiftPagerAdapter(this.bcU);
            this.jWB.setAdapter(this.jWI);
            this.jWB.setCurrentItem(this.bcY);
            Gz();
        }
    }

    private View bT(boolean z) {
        View inflate = LayoutInflater.from(this.jXM.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
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
                    if (GiftTabView.this.jXY != null) {
                        GiftTabView.this.bdh.append(GiftTabView.this.bda, true);
                        GiftTabView.this.jXY.Bo(((com.baidu.tieba.gift.giftTab.c) GiftTabView.this.bcv.get(GiftTabView.this.bda)).getCategoryId());
                    }
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jXx != null) {
                        GiftTabView.this.jXx.GF();
                    }
                }
            });
        }
        return inflate;
    }

    private GridView h(List<ai> list, int i) {
        com.baidu.tieba.gift.giftTab.b bVar = new com.baidu.tieba.gift.giftTab.b(this.jXM.getPageContext().getPageActivity());
        bVar.setGiftItems(list);
        bVar.cR(i);
        TableLineGridView tableLineGridView = new TableLineGridView(this.jXM.getPageContext().getPageActivity());
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
            this.bcL.removeAllViews();
            int size = arrayList.size();
            int equipmentWidth = l.getEquipmentWidth(this.jXM.getPageContext().getPageActivity());
            if (size >= 5) {
                i = equipmentWidth / 5;
            } else {
                i = equipmentWidth / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.a aVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && aVar.Bq() != null && aVar.Bq().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.jXM.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                    textView.setText(aVar.getCategoryName());
                    linearLayout.setOnClickListener(new d(i2));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.bcL.addView(linearLayout, layoutParams);
                }
            }
            de(this.bda);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int min = Math.min(this.mPosition, GiftTabView.this.bdg.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = GiftTabView.this.bdg.get(i) + i2;
            }
            GiftTabView.this.bcY = i2;
            GiftTabView.this.jWB.setCurrentItem(GiftTabView.this.bcY);
            GiftTabView.this.Gz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
            GiftTabView.this.jWy.setText("" + i2);
            GiftTabView.this.jWy.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (GiftTabView.this.bcx == null || GiftTabView.this.bcx.size() <= 0) {
                GiftTabView.this.rQ(true);
                Selection.selectAll(GiftTabView.this.jWy.getText());
                GiftTabView.this.jWF.setVisibility(8);
                GiftTabView.this.rS(true);
                return;
            }
            if (i == GiftTabView.this.bcx.size()) {
                GiftTabView.this.rQ(true);
                Selection.selectAll(GiftTabView.this.jWy.getText());
            } else {
                GiftTabView.this.jWy.setCursorVisible(true);
                GiftTabView.this.jWy.setFocusable(true);
                com.baidu.tieba.gift.giftTab.e eVar = (com.baidu.tieba.gift.giftTab.e) GiftTabView.this.bcx.get(i);
                if (eVar != null) {
                    GiftTabView.this.jWy.setText("" + eVar.getNumber());
                }
            }
            GiftTabView.this.jWF.setVisibility(8);
            GiftTabView.this.rS(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rS(boolean z) {
        long j;
        if (this.jXZ == null) {
            return 0L;
        }
        int i = com.baidu.adp.lib.f.b.toInt(this.jWy.getText().toString(), 0);
        this.bdf = i;
        int i2 = this.jXZ.aJs;
        switch (i2) {
            case 3:
                j = (this.jXZ.ePt >= 0 ? this.jXZ.ePt : 0L) * i;
                break;
            case 4:
            default:
                j = (this.jXZ.price >= 0 ? this.jXZ.price : 0L) * i;
                break;
            case 5:
                j = 0;
                break;
        }
        if (z) {
            this.jWz.setText(g.m(j, true));
            if (i <= 0) {
                ap.setBackgroundResource(this.jWA, R.drawable.btn_gift_give_d);
                this.jWA.setEnabled(false);
            } else if (i2 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < this.jXZ.beginTime || currentTimeMillis > this.jXZ.endTime) {
                    ap.setBackgroundResource(this.jWA, R.drawable.btn_gift_give_d);
                    this.jWA.setEnabled(false);
                } else {
                    ap.setBackgroundResource(this.jWA, R.drawable.orange_btn_selector);
                    this.jWA.setEnabled(true);
                }
            } else {
                ap.setBackgroundResource(this.jWA, R.drawable.orange_btn_selector);
                this.jWA.setEnabled(true);
            }
            this.jXO.setText(g.A((this.jXZ.ePx >= 0 ? this.jXZ.ePx : 0L) * i, this.currencyType));
            return j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        this.jWy.setCursorVisible(z);
        this.jWy.setFocusable(z);
        this.jWy.setFocusableInTouchMode(z);
        if (z) {
            this.jWy.requestFocus();
        } else {
            this.jWy.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GiftTabView.this.bcZ = GiftTabView.this.bcY;
            GiftTabView.this.mSelectedPosition = i;
            l.hideSoftKeyPad(GiftTabView.this.jXM.getPageContext().getPageActivity(), GiftTabView.this.jWy);
            com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) adapterView.getAdapter();
            if (bVar != null) {
                ai item = bVar.getItem(i);
                if (item != null) {
                    GiftTabView.this.jXZ = item;
                }
                bVar.cR(i);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.cOe();
            GiftTabView.this.cOf();
            GiftTabView.this.rS(true);
        }
    }

    public void cOc() {
        this.jYf.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOd() {
        String str;
        if (this.jXZ != null && this.jXZ.aJs == 1) {
            String str2 = null;
            String str3 = null;
            int i = this.jXZ.aJs;
            if (!StringUtils.isNull(this.jXZ.desc)) {
                str = "\"" + this.jXZ.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.jXZ.beginTime && currentTimeMillis < this.jXZ.endTime) {
                j = (this.jXZ.endTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jXM.getPageContext().getString(R.string.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.jXZ.beginTime) {
                j = (this.jXZ.beginTime - currentTimeMillis) * 1000;
                str3 = au.getTimeSpace(j);
                str2 = String.format(this.jXM.getPageContext().getString(R.string.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.jXZ.endTime) {
                str2 = this.jXM.getPageContext().getString(R.string.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, null));
            this.jXR.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jYg = true;
                    this.jYf.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jYg) {
                    this.jYg = false;
                    this.jYf.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jYf.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOf() {
        String str;
        if (this.jXM.accountType == 1) {
            this.mRoot.findViewById(R.id.desc_parent_view).setVisibility(8);
        } else if (this.jXZ != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i = this.jXZ.aJs;
            if (!StringUtils.isNull(this.jXZ.desc)) {
                str = "\"" + this.jXZ.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (i) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.jXZ.beginTime && currentTimeMillis < this.jXZ.endTime) {
                        j = (this.jXZ.endTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jXM.getPageContext().getString(R.string.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.jXZ.beginTime) {
                        j = (this.jXZ.beginTime - currentTimeMillis) * 1000;
                        str3 = au.getTimeSpace(j);
                        str2 = String.format(this.jXM.getPageContext().getString(R.string.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.jXZ.endTime) {
                        str2 = this.jXM.getPageContext().getString(R.string.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.jXM.getPageContext().getString(R.string.left_number), Integer.valueOf(this.jXZ.aYZ));
                    str3 = "" + this.jXZ.aYZ;
                    break;
                case 3:
                    str4 = String.format(this.jXM.getPageContext().getString(R.string.original_price), au.formatOverBaiwanNum(this.jXZ.price));
                    str3 = String.format(this.jXM.getPageContext().getString(R.string.discount_price), au.formatOverBaiwanNum(this.jXZ.ePt));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.jXM.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = "" + this.freeChance;
                        this.jWy.setText("" + this.freeChance);
                        break;
                    } else {
                        this.jWy.setText("0");
                        this.jWA.setEnabled(false);
                        str2 = this.jXM.getPageContext().getString(R.string.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (i == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.jXS.setVisibility(0);
            } else {
                this.jXS.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aJ(str2, str3, str4));
            this.jXR.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jYg = true;
                    this.jYf.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jYg) {
                    this.jYg = false;
                    this.jYf.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jYf.removeCallbacks(this.runnable);
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
        this.bcY = i;
        Gz();
        if (i >= 0 && i < this.bcU.size() && (this.bcU.get(i) instanceof GridView)) {
            GridView gridView = (GridView) this.bcU.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) gridView.getAdapter();
                if (bVar.FY() >= 0 && i != this.bcZ) {
                    bVar.cR(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.FY() < 0 && i == this.bcZ) {
                    bVar.cR(this.mSelectedPosition);
                    bVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz() {
        int i = 0;
        for (int i2 = 0; i2 < this.bdg.size(); i2++) {
            for (int i3 = 0; i3 < this.bdg.get(i2); i3++) {
                if (i + i3 == this.bcY) {
                    if (this.bdg.get(i2) <= 1) {
                        this.jWC.setVisibility(4);
                    } else {
                        this.jWC.setVisibility(0);
                    }
                    this.jWC.setCount(this.bdg.get(i2));
                    this.jWC.setPosition(i3);
                    de(i2);
                    return;
                }
            }
            i += this.bdg.get(i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void de(int i) {
        int childCount = this.bcL.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                LinearLayout linearLayout = (LinearLayout) this.bcL.getChildAt(i2);
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
                    df(i);
                    this.bda = i;
                    this.bcK.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    private void df(int i) {
        int childCount = this.bcL.getChildCount();
        if (i >= 0 && i < childCount && this.bcv != null && this.bcv.size() > i && this.bcv.get(i) != null && !this.bdh.get(i)) {
            if ((this.bcv.get(i).Ez() == null || this.bcv.get(i).Ez().size() <= 0) && this.jXY != null) {
                this.bdh.append(i, true);
                this.jXY.Bo(this.bcv.get(i).getCategoryId());
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
        this.jXW = new com.baidu.tieba.gift.giftTab.d(this.jXM.getPageContext().getPageActivity());
        this.jWG.setAdapter((ListAdapter) this.jXW);
        this.jXW.J(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.jXM.getPageContext(), this.jWx);
        ap.setBackgroundResource(this.jWG, R.drawable.chx_box_im_gift);
        if (this.jXW != null) {
            this.jXW.notifyDataSetChanged();
        }
        this.jWC.setSelector(ap.getDrawable(R.drawable.point_live_s));
        this.jWC.setDrawable(ap.getDrawable(R.drawable.point_live_n));
    }

    public void cOg() {
        if (this.jXX == null) {
            this.jXX = new com.baidu.tbadk.core.view.a(this.jXM.getPageContext());
        }
        this.jXX.setDialogVisiable(true);
    }

    public void cOh() {
        if (this.jXX != null) {
            this.jXX.setDialogVisiable(false);
        }
    }

    public void Br(int i) {
        this.freeChance = i;
        cOe();
        if (this.jXZ != null && this.jXZ.aJs == 5) {
            cOf();
        }
    }

    public void a(f fVar) {
        this.jXY = fVar;
    }

    public void a(e eVar) {
        this.jXx = eVar;
    }

    public void LD(String str) {
        this.addFreeUrl = str;
    }

    public int GB() {
        return this.bdf;
    }

    public ai cOi() {
        return this.jXZ;
    }
}
