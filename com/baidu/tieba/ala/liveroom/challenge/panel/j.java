package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends g {
    private boolean bBF;
    private TextView bBo;
    private View.OnClickListener bBu;
    private CommonEmptyView bmS;
    public a gKj;
    private EditText gKo;
    private View gKp;
    private ImageView gKq;
    private i gKr;
    private String gKs;
    private TextWatcher gKt;
    private View.OnFocusChangeListener gKu;
    private View.OnTouchListener gKv;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes4.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, n nVar) {
        super(context, nVar);
        this.pn = 1;
        this.bBu = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.bBF = false;
                if (TextUtils.isEmpty(j.this.gKs)) {
                    j.this.gJV.bM(j.this.pn, 30);
                } else {
                    j.this.gJV.j(j.this.pn, 10, j.this.gKs);
                }
            }
        };
        this.gKj = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gJV.X(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gKq) {
                    if (view == j.this.gKp) {
                        j.this.gKo.setText("");
                        return;
                    }
                    return;
                }
                j.this.gJV.bUQ();
            }
        };
        this.gKt = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.bBF = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gKs = "";
                    j.this.gKp.setVisibility(8);
                    j.this.gJV.bM(j.this.pn, 30);
                    return;
                }
                j.this.gKs = charSequence.toString();
                j.this.gKp.setVisibility(0);
                j.this.gJV.j(j.this.pn, 10, j.this.gKs);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gKu = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                }
            }
        };
        this.mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    BdUtilHelper.hideSoftKeyPad(j.this.mContext, textView);
                    return true;
                }
                return false;
            }
        };
        this.gKv = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gKq = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gKq.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gKr = new i(context);
        this.gKr.a(this.gKj);
        this.mListView.setAdapter((ListAdapter) this.gKr);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.bBF) {
                    j.this.bBF = true;
                    if (TextUtils.isEmpty(j.this.gKs)) {
                        j.this.gJV.bM(j.this.pn, 30);
                    } else {
                        j.this.gJV.j(j.this.pn, 10, j.this.gKs);
                    }
                }
            }
        });
        this.bBo = new TextView(this.mContext);
        this.bBo.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.bBo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.bBo.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bBo.setGravity(17);
        this.gKp = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gKp.setOnClickListener(this.mClickListener);
        this.gKo = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gKo.addTextChangedListener(this.gKt);
        this.gKo.setOnFocusChangeListener(this.gKu);
        this.gKo.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gKo.setOnTouchListener(this.gKv);
        this.mListView.setOnTouchListener(this.gKv);
        this.mRootView.setOnTouchListener(this.gKv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_user_choose_view, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void b(FrameLayout frameLayout, int i) {
        super.b(frameLayout, i);
        this.pn = 1;
        this.bBF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gJV.bUQ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bUU() {
        super.bUU();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gKo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gKr != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.bBo);
            this.gKr.bUX();
        }
        this.gKo.setText("");
        SK();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gKr != null) {
            this.gKr.i(dVar);
        }
    }

    public void bUJ() {
        if (this.gKr != null) {
            this.gKr.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bmS == null) {
                this.bmS = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bmS.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bmS.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bmS.setTitle(i);
            this.bmS.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bmS.setRefreshButton(a.i.ala_click_retry, this.bBu);
            }
            this.bmS.setVisibility(0);
        }
    }

    public void SK() {
        if (this.bmS != null) {
            this.bmS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.bBF = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gKs)) {
                    a(a.i.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                    return;
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_RANK_LIST);
                    return;
                } else {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_DATA);
                    return;
                }
            }
            this.mListView.setVisibility(0);
            SK();
            if (bVar.pn == 1) {
                this.gKr.setDatas(list);
            } else {
                this.gKr.cg(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                SI();
            } else {
                SJ();
            }
        }
    }

    private void SI() {
        this.bBo.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bBo);
        this.mListView.addFooterView(this.bBo);
    }

    private void SJ() {
        this.bBo.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.bBo);
        this.mListView.addFooterView(this.bBo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bb(int i, String str) {
        this.bBF = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gKr.getCount() <= 0 || this.pn == 1) {
            if (this.mListView.getVisibility() == 0) {
                this.mListView.setVisibility(8);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }
    }
}
