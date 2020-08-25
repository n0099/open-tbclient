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
/* loaded from: classes7.dex */
public class j extends g {
    private CommonEmptyView bgl;
    private View.OnClickListener fSF;
    private TextWatcher gsA;
    private View.OnFocusChangeListener gsB;
    private View.OnTouchListener gsC;
    public a gso;
    private EditText gst;
    private View gsu;
    private ImageView gsv;
    private i gsw;
    private TextView gsx;
    private boolean gsy;
    private String gsz;
    private View.OnClickListener mClickListener;
    private boolean mHasMore;
    private BdListView mListView;
    private TextView.OnEditorActionListener mOnEditorActionListener;
    private int pn;

    /* loaded from: classes7.dex */
    public interface a {
        void f(com.baidu.live.challenge.d dVar);
    }

    public j(Context context, m mVar) {
        super(context, mVar);
        this.pn = 1;
        this.fSF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.pn = 1;
                j.this.gsy = false;
                if (TextUtils.isEmpty(j.this.gsz)) {
                    j.this.gsa.bM(j.this.pn, 30);
                } else {
                    j.this.gsa.h(j.this.pn, 10, j.this.gsz);
                }
            }
        };
        this.gso = new a() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.3
            @Override // com.baidu.tieba.ala.liveroom.challenge.panel.j.a
            public void f(com.baidu.live.challenge.d dVar) {
                if (dVar != null) {
                    j.this.gsa.W(dVar.userId);
                }
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != j.this.gsv) {
                    if (view == j.this.gsu) {
                        j.this.gst.setText("");
                        return;
                    }
                    return;
                }
                j.this.gsa.bQd();
            }
        };
        this.gsA = new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                j.this.pn = 1;
                j.this.gsy = false;
                if (charSequence == null || charSequence.length() == 0) {
                    j.this.gsz = "";
                    j.this.gsu.setVisibility(8);
                    j.this.gsa.bM(j.this.pn, 30);
                    return;
                }
                j.this.gsz = charSequence.toString();
                j.this.gsu.setVisibility(0);
                j.this.gsa.h(j.this.pn, 10, j.this.gsz);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.gsB = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.6
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
        this.gsC = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BdUtilHelper.hideSoftKeyPad(j.this.mContext, view);
                return false;
            }
        };
        this.gsv = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_user_choose_back);
        this.gsv.setOnClickListener(this.mClickListener);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.ala_challenge_user_list);
        this.gsw = new i(context);
        this.gsw.a(this.gso);
        this.mListView.setAdapter((ListAdapter) this.gsw);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.j.2
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (j.this.mHasMore && !j.this.gsy) {
                    j.this.gsy = true;
                    if (TextUtils.isEmpty(j.this.gsz)) {
                        j.this.gsa.bM(j.this.pn, 30);
                    } else {
                        j.this.gsa.h(j.this.pn, 10, j.this.gsz);
                    }
                }
            }
        });
        this.gsx = new TextView(this.mContext);
        this.gsx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.gsx.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.gsx.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.gsx.setGravity(17);
        this.gsu = this.mRootView.findViewById(a.g.delete_search_pk_textview);
        this.gsu.setOnClickListener(this.mClickListener);
        this.gst = (EditText) this.mRootView.findViewById(a.g.search_pk_edittext);
        this.gst.addTextChangedListener(this.gsA);
        this.gst.setOnFocusChangeListener(this.gsB);
        this.gst.setOnEditorActionListener(this.mOnEditorActionListener);
        this.gst.setOnTouchListener(this.gsC);
        this.mListView.setOnTouchListener(this.gsC);
        this.mRootView.setOnTouchListener(this.gsC);
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
        this.gsy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.gsa.bQd();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds560) * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void bQg() {
        super.bQg();
        BdUtilHelper.hideSoftKeyPad(this.mContext, this.gst);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gsw != null) {
            this.mListView.setSelection(0);
            this.mListView.removeFooterView(this.gsx);
            this.gsw.bQj();
        }
        this.gst.setText("");
        bFW();
    }

    public void j(com.baidu.live.challenge.d dVar) {
        if (this.gsw != null) {
            this.gsw.i(dVar);
        }
    }

    public void bPW() {
        if (this.gsw != null) {
            this.gsw.notifyDataSetChanged();
        }
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bgl == null) {
                this.bgl = new CommonEmptyView(this.mContext);
                if (this.mRootView instanceof RelativeLayout) {
                    this.bgl.addToParent((RelativeLayout) this.mRootView);
                } else if (this.mRootView instanceof FrameLayout) {
                    this.bgl.addToParent((FrameLayout) this.mRootView);
                }
            }
            this.bgl.setTitle(i);
            this.bgl.setup(imgType, CommonEmptyView.StyleType.DARK);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bgl.setRefreshButton(a.i.ala_click_retry, this.fSF);
            }
            this.bgl.setVisibility(0);
        }
    }

    public void bFW() {
        if (this.bgl != null) {
            this.bgl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.live.challenge.b bVar, List<com.baidu.live.challenge.d> list) {
        this.gsy = false;
        if (bVar != null && this.mRootView.getParent() != null) {
            if (ListUtils.isEmpty(list) && bVar.pn == 1) {
                this.mListView.setVisibility(8);
                if (TextUtils.isEmpty(this.gsz)) {
                    a(a.i.ala_challenge_empty_challenger, CommonEmptyView.ImgType.NO_DATA);
                    return;
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_RANK_LIST);
                    return;
                } else {
                    a(a.i.ala_challenge_search_empty, CommonEmptyView.ImgType.NO_DATA);
                    return;
                }
            }
            this.mListView.setVisibility(0);
            bFW();
            if (bVar.pn == 1) {
                this.gsw.setDatas(list);
            } else {
                this.gsw.bY(list);
            }
            this.pn = bVar.pn + 1;
            this.mHasMore = bVar.hasMore;
            if (bVar.hasMore) {
                bGR();
            } else {
                bGS();
            }
        }
    }

    private void bGR() {
        this.gsx.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.gsx);
        this.mListView.addFooterView(this.gsx);
    }

    private void bGS() {
        this.gsx.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.gsx);
        this.mListView.addFooterView(this.gsx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aR(int i, String str) {
        this.gsy = false;
        BdUtilHelper.showToast(this.mContext, str);
        if (this.gsw.getCount() <= 0 || this.pn == 1) {
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
