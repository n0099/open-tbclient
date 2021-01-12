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
/* loaded from: classes8.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    private ArrayList<com.baidu.tieba.gift.giftTab.c> aXO;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> aXP;
    private ArrayList<com.baidu.tieba.gift.giftTab.e> aXQ;
    protected View aXX;
    protected HorizontalScrollView aYd;
    protected LinearLayout aYe;
    private int aYy;
    private String addFreeUrl;
    public int currencyType;
    protected FrameLayout jMD;
    protected View jME;
    protected View jMF;
    protected EditText jMG;
    protected TextView jMH;
    protected TextView jMI;
    protected BaseViewPager jMJ;
    protected IndicatorView jMK;
    protected View jML;
    protected View jMN;
    protected ListView jMO;
    protected GiftPagerAdapter jMQ;
    private View.OnClickListener jND;
    private e jNF;
    private GiftTabActivity jNU;
    protected View jNV;
    protected TextView jNW;
    protected TextView jNX;
    protected ImageView jNY;
    protected TextView jNZ;
    protected TextView jOa;
    protected TextView jOb;
    protected View jOc;
    protected FrameLayout jOd;
    protected com.baidu.tieba.gift.giftTab.d jOe;
    protected com.baidu.tbadk.core.view.a jOf;
    private f jOg;
    private ah jOh;
    private int jOi;
    private int jOj;
    private int jOk;
    private View mRoot;
    public ai urlTitleData;
    protected List<View> aYn = new ArrayList();
    private int freeChance = 0;
    private int aYr = 0;
    private int aYs = 0;
    private int mSelectedPosition = 0;
    private int aYt = 0;
    private SparseIntArray aYz = new SparseIntArray();
    private SparseBooleanArray aYA = new SparseBooleanArray();
    private View.OnClickListener jOl = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(GiftTabView.this.urlTitleData.eLM)) {
                be.bsB().b(GiftTabView.this.jNU.getPageContext(), new String[]{GiftTabView.this.urlTitleData.eLM});
            }
        }
    };
    private View.OnClickListener jOm = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.hideSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
        }
    };
    Handler jOn = new Handler();
    Runnable runnable = new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.9
        @Override // java.lang.Runnable
        public void run() {
            GiftTabView.this.cLS();
            GiftTabView.this.rH(true);
        }
    };
    boolean jOo = false;

    /* loaded from: classes8.dex */
    public interface e {
        void Fm();
    }

    /* loaded from: classes8.dex */
    public interface f {
        void AW(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        this.jOi = 0;
        this.jOj = 0;
        this.jOk = 0;
        this.jNU = giftTabActivity;
        this.jND = onClickListener;
        this.mRoot = LayoutInflater.from(this.jNU.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.jNU.setContentView(this.mRoot);
        initViews();
        this.jOi = l.getStatusBarHeight(this.jNU.getActivity());
        this.jOj = l.getDimens(this.jNU.getActivity(), R.dimen.ds330);
        this.jOk = l.getDimens(this.jNU.getActivity(), R.dimen.ds10);
    }

    private void initViews() {
        this.jMD = (FrameLayout) this.mRoot.findViewById(R.id.gift_panel_lay);
        this.jME = this.mRoot.findViewById(R.id.empty_layout);
        this.jME.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GiftTabView.this.jMN.getVisibility() != 0) {
                    GiftTabView.this.jNU.closeActivity();
                } else {
                    GiftTabView.this.jMN.setVisibility(8);
                }
            }
        });
        this.aXX = this.mRoot.findViewById(R.id.gift_count_layout);
        this.aXX.setOnClickListener(this.jOm);
        this.jMF = this.mRoot.findViewById(R.id.gift_list_layout);
        this.jMG = (EditText) this.mRoot.findViewById(R.id.gift_count_input);
        this.jMG.setSelection(1);
        rF(false);
        this.jMG.addTextChangedListener(new c());
        this.jMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.hideSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
                GiftTabView.this.jNU.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GiftTabView.this.rF(false);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(GiftTabView.this.jOj, -2);
                        int[] iArr = new int[2];
                        GiftTabView.this.jMG.getLocationOnScreen(iArr);
                        layoutParams.leftMargin = iArr[0] - GiftTabView.this.jOk;
                        int i = (iArr[1] - GiftTabView.this.jOi) - GiftTabView.this.jOk;
                        if (UtilHelper.canUseStyleImmersiveSticky()) {
                            i += UtilHelper.getStatusBarHeight();
                        }
                        layoutParams.topMargin = i;
                        GiftTabView.this.jMO.setLayoutParams(layoutParams);
                        GiftTabView.this.jMN.setVisibility(0);
                    }
                }, 200L);
            }
        });
        this.jMG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    l.showSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
                } else {
                    l.hideSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
                }
            }
        });
        this.jNV = this.mRoot.findViewById(R.id.reward_parent_view);
        this.jNW = (TextView) this.mRoot.findViewById(R.id.reward_count_result);
        this.jNX = (TextView) this.mRoot.findViewById(R.id.reward_jump);
        this.jNY = (ImageView) this.mRoot.findViewById(R.id.reward_jump_arrow);
        this.jNV.setOnClickListener(this.jOl);
        this.jMH = (TextView) this.mRoot.findViewById(R.id.gift_count_result);
        this.jMI = (TextView) this.mRoot.findViewById(R.id.gift_button);
        this.jMI.setEnabled(false);
        this.jMI.setOnClickListener(this.jND);
        this.jNZ = (TextView) this.mRoot.findViewById(R.id.gift_desc_view);
        this.jNZ.setOnClickListener(this.jOm);
        this.jOa = (TextView) this.mRoot.findViewById(R.id.get_free_chance_view);
        this.jOa.setOnClickListener(this.jND);
        this.jOb = (TextView) this.mRoot.findViewById(R.id.text_view_gift_to);
        this.jOb.setOnClickListener(this.jOm);
        this.jML = this.mRoot.findViewById(R.id.gift_lower_layout);
        this.jMJ = (BaseViewPager) this.mRoot.findViewById(R.id.gift_viewpager);
        this.jMJ.setOnPageChangeListener(this);
        this.jMK = (IndicatorView) this.mRoot.findViewById(R.id.gift_tab_indicator);
        this.aYe = (LinearLayout) this.mRoot.findViewById(R.id.gift_tab_layout);
        this.aYd = (HorizontalScrollView) this.mRoot.findViewById(R.id.gift_tab_scrollview);
        this.jMN = this.mRoot.findViewById(R.id.gift_num_layout);
        this.jMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GiftTabView.this.jMN.setVisibility(8);
                l.hideSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
            }
        });
        this.jMO = (ListView) this.mRoot.findViewById(R.id.gift_num_list);
        this.jMO.setOnItemClickListener(new b());
        this.jOd = (FrameLayout) this.mRoot.findViewById(R.id.tab_container_view);
        this.jOc = bO(false);
        this.jOc.setVisibility(8);
        this.jOd.addView(this.jOc);
    }

    public void a(boolean z, ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<com.baidu.tieba.gift.giftTab.e> arrayList3) {
        this.aXO = arrayList;
        this.aXP = arrayList2;
        this.aXQ = arrayList3;
        rG(z);
    }

    private void rG(boolean z) {
        Fd();
        cLW();
        if (this.aXO == null || this.aXO.size() <= 0) {
            this.jML.setVisibility(8);
            this.jOc.setVisibility(0);
            return;
        }
        this.jMI.setEnabled(true);
        this.jOc.setVisibility(8);
        this.jML.setVisibility(0);
        if (z) {
            h(this.aXP);
            K(this.aXQ);
        }
        c(this.aXO, z);
        cLT();
        cLU();
        rH(true);
    }

    private void Fd() {
        if (x.getCount(this.aXP) != 0 && x.getCount(this.aXO) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.aXP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || x.getCount(next.AD()) == 0)) {
                    arrayList.add(next);
                    Iterator<com.baidu.tieba.gift.giftTab.c> it2 = this.aXO.iterator();
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
                this.aXP.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aXO.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<com.baidu.tieba.gift.giftTab.c> arrayList, boolean z) {
        int i;
        List<ah> subList;
        if (arrayList != null) {
            this.aYz.clear();
            this.aYn.clear();
            this.jMJ.setAdapter(null);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                List<ah> Dg = arrayList.get(i2).Dg();
                int size = Dg != null ? Dg.size() : 0;
                if (size <= 0) {
                    List<ah> arrayList2 = new ArrayList<>();
                    if (!this.aYA.get(i2)) {
                        this.aYn.add(h(arrayList2, -1));
                    } else {
                        this.aYn.add(bO(true));
                    }
                    i = 1;
                } else {
                    int ceil = (int) Math.ceil(size / 8.0d);
                    for (int i3 = 0; i3 < ceil; i3++) {
                        if (i3 == ceil - 1) {
                            if (i3 * 8 == size - 1) {
                                subList = new ArrayList<>();
                                subList.add(Dg.get(size - 1));
                            } else {
                                subList = Dg.subList(i3 * 8, size);
                            }
                        } else {
                            subList = Dg.subList(i3 * 8, (i3 + 1) * 8);
                        }
                        if (i2 == 0 && i3 == 0 && z) {
                            this.aYn.add(h(subList, 0));
                            this.jOh = subList.get(0);
                        } else {
                            this.aYn.add(h(subList, -1));
                        }
                    }
                    i = ceil;
                }
                this.aYz.append(i2, i);
            }
            this.jMQ = new GiftPagerAdapter(this.aYn);
            this.jMJ.setAdapter(this.jMQ);
            this.jMJ.setCurrentItem(this.aYr);
            Fg();
        }
    }

    private View bO(boolean z) {
        View inflate = LayoutInflater.from(this.jNU.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
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
                    if (GiftTabView.this.jOg != null) {
                        GiftTabView.this.aYA.append(GiftTabView.this.aYt, true);
                        GiftTabView.this.jOg.AW(((com.baidu.tieba.gift.giftTab.c) GiftTabView.this.aXO.get(GiftTabView.this.aYt)).getCategoryId());
                    }
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GiftTabView.this.jNF != null) {
                        GiftTabView.this.jNF.Fm();
                    }
                }
            });
        }
        return inflate;
    }

    private GridView h(List<ah> list, int i) {
        com.baidu.tieba.gift.giftTab.b bVar = new com.baidu.tieba.gift.giftTab.b(this.jNU.getPageContext().getPageActivity());
        bVar.setGiftItems(list);
        bVar.cL(i);
        TableLineGridView tableLineGridView = new TableLineGridView(this.jNU.getPageContext().getPageActivity());
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
    private void h(ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList) {
        int i;
        if (arrayList != null && arrayList.size() > 0) {
            this.aYe.removeAllViews();
            int size = arrayList.size();
            int equipmentWidth = l.getEquipmentWidth(this.jNU.getPageContext().getPageActivity());
            if (size >= 5) {
                i = equipmentWidth / 5;
            } else {
                i = equipmentWidth / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -1);
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.gift.giftTab.a aVar = arrayList.get(i2);
                if (!TextUtils.isEmpty(aVar.getCategoryName()) && aVar.AD() != null && aVar.AD().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.jNU.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                    textView.setText(aVar.getCategoryName());
                    linearLayout.setOnClickListener(new d(i2));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.aYe.addView(linearLayout, layoutParams);
                }
            }
            cY(this.aYt);
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
            int min = Math.min(this.mPosition, GiftTabView.this.aYz.size());
            int i = 0;
            int i2 = 0;
            while (i < min) {
                i++;
                i2 = GiftTabView.this.aYz.get(i) + i2;
            }
            GiftTabView.this.aYr = i2;
            GiftTabView.this.jMJ.setCurrentItem(GiftTabView.this.aYr);
            GiftTabView.this.Fg();
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
                GiftTabView.this.rH(true);
                return;
            }
            int i2 = i >= 0 ? i : 0;
            GiftTabView.this.jMG.setText("" + i2);
            GiftTabView.this.jMG.setSelection(String.valueOf(i2).length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (GiftTabView.this.aXQ == null || GiftTabView.this.aXQ.size() <= 0) {
                GiftTabView.this.rF(true);
                Selection.selectAll(GiftTabView.this.jMG.getText());
                GiftTabView.this.jMN.setVisibility(8);
                GiftTabView.this.rH(true);
                return;
            }
            if (i == GiftTabView.this.aXQ.size()) {
                GiftTabView.this.rF(true);
                Selection.selectAll(GiftTabView.this.jMG.getText());
            } else {
                GiftTabView.this.jMG.setCursorVisible(true);
                GiftTabView.this.jMG.setFocusable(true);
                com.baidu.tieba.gift.giftTab.e eVar = (com.baidu.tieba.gift.giftTab.e) GiftTabView.this.aXQ.get(i);
                if (eVar != null) {
                    GiftTabView.this.jMG.setText("" + eVar.getNumber());
                }
            }
            GiftTabView.this.jMN.setVisibility(8);
            GiftTabView.this.rH(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long rH(boolean z) {
        long j;
        if (this.jOh == null) {
            return 0L;
        }
        int i = com.baidu.adp.lib.f.b.toInt(this.jMG.getText().toString(), 0);
        this.aYy = i;
        int i2 = this.jOh.aFw;
        switch (i2) {
            case 3:
                j = (this.jOh.eLG >= 0 ? this.jOh.eLG : 0L) * i;
                break;
            case 4:
            default:
                j = (this.jOh.price >= 0 ? this.jOh.price : 0L) * i;
                break;
            case 5:
                j = 0;
                break;
        }
        if (z) {
            this.jMH.setText(g.m(j, true));
            if (i <= 0) {
                ao.setBackgroundResource(this.jMI, R.drawable.btn_gift_give_d);
                this.jMI.setEnabled(false);
            } else if (i2 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < this.jOh.beginTime || currentTimeMillis > this.jOh.endTime) {
                    ao.setBackgroundResource(this.jMI, R.drawable.btn_gift_give_d);
                    this.jMI.setEnabled(false);
                } else {
                    ao.setBackgroundResource(this.jMI, R.drawable.orange_btn_selector);
                    this.jMI.setEnabled(true);
                }
            } else {
                ao.setBackgroundResource(this.jMI, R.drawable.orange_btn_selector);
                this.jMI.setEnabled(true);
            }
            this.jNW.setText(g.C((this.jOh.eLK >= 0 ? this.jOh.eLK : 0L) * i, this.currencyType));
            return j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF(boolean z) {
        this.jMG.setCursorVisible(z);
        this.jMG.setFocusable(z);
        this.jMG.setFocusableInTouchMode(z);
        if (z) {
            this.jMG.requestFocus();
        } else {
            this.jMG.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            GiftTabView.this.aYs = GiftTabView.this.aYr;
            GiftTabView.this.mSelectedPosition = i;
            l.hideSoftKeyPad(GiftTabView.this.jNU.getPageContext().getPageActivity(), GiftTabView.this.jMG);
            com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) adapterView.getAdapter();
            if (bVar != null) {
                ah item = bVar.getItem(i);
                if (item != null) {
                    GiftTabView.this.jOh = item;
                }
                bVar.cL(i);
                bVar.notifyDataSetChanged();
            }
            GiftTabView.this.cLT();
            GiftTabView.this.cLU();
            GiftTabView.this.rH(true);
        }
    }

    public void cLR() {
        this.jOn.removeCallbacks(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLS() {
        String str;
        if (this.jOh != null && this.jOh.aFw == 1) {
            String str2 = null;
            String str3 = null;
            int i = this.jOh.aFw;
            if (!StringUtils.isNull(this.jOh.desc)) {
                str = "\"" + this.jOh.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis > this.jOh.beginTime && currentTimeMillis < this.jOh.endTime) {
                j = (this.jOh.endTime - currentTimeMillis) * 1000;
                str3 = at.getTimeSpace(j);
                str2 = String.format(this.jNU.getPageContext().getString(R.string.gift_limit_time_end), str3);
            } else if (currentTimeMillis < this.jOh.beginTime) {
                j = (this.jOh.beginTime - currentTimeMillis) * 1000;
                str3 = at.getTimeSpace(j);
                str2 = String.format(this.jNU.getPageContext().getString(R.string.gift_limit_time_start), str3);
            } else if (currentTimeMillis > this.jOh.endTime) {
                str2 = this.jNU.getPageContext().getString(R.string.gift_limit_time_has_over);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aI(str2, str3, null));
            this.jNZ.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jOo = true;
                    this.jOn.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jOo) {
                    this.jOo = false;
                    this.jOn.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jOn.removeCallbacks(this.runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLU() {
        String str;
        if (this.jNU.accountType == 1) {
            this.mRoot.findViewById(R.id.desc_parent_view).setVisibility(8);
        } else if (this.jOh != null) {
            String str2 = null;
            String str3 = null;
            String str4 = null;
            int i = this.jOh.aFw;
            if (!StringUtils.isNull(this.jOh.desc)) {
                str = "\"" + this.jOh.desc + "\" ";
            } else {
                str = "";
            }
            long j = 0;
            switch (i) {
                case 1:
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (currentTimeMillis > this.jOh.beginTime && currentTimeMillis < this.jOh.endTime) {
                        j = (this.jOh.endTime - currentTimeMillis) * 1000;
                        str3 = at.getTimeSpace(j);
                        str2 = String.format(this.jNU.getPageContext().getString(R.string.gift_limit_time_end), str3);
                        break;
                    } else if (currentTimeMillis < this.jOh.beginTime) {
                        j = (this.jOh.beginTime - currentTimeMillis) * 1000;
                        str3 = at.getTimeSpace(j);
                        str2 = String.format(this.jNU.getPageContext().getString(R.string.gift_limit_time_start), str3);
                        break;
                    } else if (currentTimeMillis > this.jOh.endTime) {
                        str2 = this.jNU.getPageContext().getString(R.string.gift_limit_time_has_over);
                        break;
                    }
                    break;
                case 2:
                    str2 = String.format(this.jNU.getPageContext().getString(R.string.left_number), Integer.valueOf(this.jOh.aUu));
                    str3 = "" + this.jOh.aUu;
                    break;
                case 3:
                    str4 = String.format(this.jNU.getPageContext().getString(R.string.original_price), at.formatOverBaiwanNum(this.jOh.price));
                    str3 = String.format(this.jNU.getPageContext().getString(R.string.discount_price), at.formatOverBaiwanNum(this.jOh.eLG));
                    str2 = " " + str4 + "  " + str3;
                    break;
                case 4:
                    str2 = "";
                    break;
                case 5:
                    if (this.freeChance > 0) {
                        str2 = String.format(this.jNU.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance));
                        str3 = "" + this.freeChance;
                        this.jMG.setText("" + this.freeChance);
                        break;
                    } else {
                        this.jMG.setText("0");
                        this.jMI.setEnabled(false);
                        str2 = this.jNU.getPageContext().getString(R.string.have_no_free_chance);
                        break;
                    }
                default:
                    str2 = "";
                    break;
            }
            if (i == 5 && this.freeChance <= 0 && !StringUtils.isNull(this.addFreeUrl)) {
                this.jOa.setVisibility(0);
            } else {
                this.jOa.setVisibility(8);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) g.aI(str2, str3, str4));
            this.jNZ.setText(spannableStringBuilder);
            if (i == 1) {
                if (j > 0 && j <= BdKVCache.MILLS_1Hour) {
                    this.jOo = true;
                    this.jOn.postDelayed(this.runnable, 1000L);
                    return;
                } else if (this.jOo) {
                    this.jOo = false;
                    this.jOn.postDelayed(this.runnable, 1000L);
                    return;
                } else {
                    return;
                }
            }
            this.jOn.removeCallbacks(this.runnable);
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
        this.aYr = i;
        Fg();
        if (i >= 0 && i < this.aYn.size() && (this.aYn.get(i) instanceof GridView)) {
            GridView gridView = (GridView) this.aYn.get(i);
            if (gridView.getAdapter() != null) {
                com.baidu.tieba.gift.giftTab.b bVar = (com.baidu.tieba.gift.giftTab.b) gridView.getAdapter();
                if (bVar.EF() >= 0 && i != this.aYs) {
                    bVar.cL(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.EF() < 0 && i == this.aYs) {
                    bVar.cL(this.mSelectedPosition);
                    bVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fg() {
        int i = 0;
        for (int i2 = 0; i2 < this.aYz.size(); i2++) {
            for (int i3 = 0; i3 < this.aYz.get(i2); i3++) {
                if (i + i3 == this.aYr) {
                    if (this.aYz.get(i2) <= 1) {
                        this.jMK.setVisibility(4);
                    } else {
                        this.jMK.setVisibility(0);
                    }
                    this.jMK.setCount(this.aYz.get(i2));
                    this.jMK.setPosition(i3);
                    cY(i2);
                    return;
                }
            }
            i += this.aYz.get(i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void cY(int i) {
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                LinearLayout linearLayout = (LinearLayout) this.aYe.getChildAt(i2);
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
                    cZ(i);
                    this.aYt = i;
                    this.aYd.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    private void cZ(int i) {
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount && this.aXO != null && this.aXO.size() > i && this.aXO.get(i) != null && !this.aYA.get(i)) {
            if ((this.aXO.get(i).Dg() == null || this.aXO.get(i).Dg().size() <= 0) && this.jOg != null) {
                this.aYA.append(i, true);
                this.jOg.AW(this.aXO.get(i).getCategoryId());
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
        this.jOe = new com.baidu.tieba.gift.giftTab.d(this.jNU.getPageContext().getPageActivity());
        this.jMO.setAdapter((ListAdapter) this.jOe);
        this.jOe.J(list);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.jNU.getPageContext(), this.jMF);
        ao.setBackgroundResource(this.jMO, R.drawable.chx_box_im_gift);
        if (this.jOe != null) {
            this.jOe.notifyDataSetChanged();
        }
        this.jMK.setSelector(ao.getDrawable(R.drawable.point_live_s));
        this.jMK.setDrawable(ao.getDrawable(R.drawable.point_live_n));
    }

    public void cLV() {
        if (this.jOf == null) {
            this.jOf = new com.baidu.tbadk.core.view.a(this.jNU.getPageContext());
        }
        this.jOf.setDialogVisiable(true);
    }

    public void cLW() {
        if (this.jOf != null) {
            this.jOf.setDialogVisiable(false);
        }
    }

    public void AZ(int i) {
        this.freeChance = i;
        cLT();
        if (this.jOh != null && this.jOh.aFw == 5) {
            cLU();
        }
    }

    public void a(f fVar) {
        this.jOg = fVar;
    }

    public void a(e eVar) {
        this.jNF = eVar;
    }

    public void KI(String str) {
        this.addFreeUrl = str;
    }

    public int Fi() {
        return this.aYy;
    }

    public ah cLX() {
        return this.jOh;
    }
}
