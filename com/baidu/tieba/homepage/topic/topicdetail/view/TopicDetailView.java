package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private g cXp;
    private com.baidu.tbadk.editortools.pb.b cko;
    private NoNetworkView dbq;
    private PbListView dbr;
    private NoNetworkView.a emy;
    private com.baidu.tieba.homepage.topic.topicdetail.a fOM;
    private ImageView fON;
    private TopicDetailHeadView fOO;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b fOP;
    private View fOQ;
    private View fOR;
    private TextView fOS;
    private TextView fOT;
    private a fOU;
    private View fOV;
    private com.baidu.tieba.write.b fOW;
    private EditText fOX;
    private int fOY;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a fOZ;
    a.RunnableC0304a fPa;
    private int fPb;
    private int fPc;
    private NewWriteModel.d fPd;
    private View fax;
    private BdTypeRecyclerView fxw;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private BdListView.e mOnScrollToBottomListener;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.fOR = null;
        this.fOS = null;
        this.fOT = null;
        this.mHasMore = true;
        this.fPb = 0;
        this.fPc = 44;
        this.emy = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.fOM != null) {
                    TopicDetailView.this.fOM.loadData();
                }
            }
        };
        this.cko = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean amn() {
                if (TopicDetailView.this.fOW.cnY()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.fOW.coa());
                    TopicDetailView.this.kt(true);
                    return true;
                }
                return false;
            }
        };
        this.fPd = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.fOU != null && TopicDetailView.this.fOU.alP() != null) {
                    TopicDetailView.this.fOU.alP().hide();
                }
                if (z) {
                    TopicDetailView.this.fOW.Ei(null);
                    TopicDetailView.this.fOW.aE(null);
                    TopicDetailView.this.fOW.qU(false);
                    if (postWriteCallBackData != null) {
                        long d = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
                        long d2 = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
                        if (d != 0 && d2 != 0) {
                            TopicDetailView.this.fPa = TopicDetailView.this.fOZ.p(d, d2);
                            com.baidu.adp.lib.g.e.jH().postDelayed(TopicDetailView.this.fPa, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.fOW.aE(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.fOW.Ei(postWriteCallBackData.getErrorString());
                    if (!v.T(TopicDetailView.this.fOW.cnW())) {
                        TopicDetailView.this.kt(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.fOU != null) {
                    TopicDetailView.this.fOU.amM();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fxw, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.fPb += i2;
                TopicDetailView.this.bnk();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.lo()) {
                        TopicDetailView.this.aCt();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).cN(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).fOk);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.fOM = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(d.h.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.activity_topic_detail_navigation);
        if (this.fax == null) {
            this.fax = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fax.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fax.findViewById(d.g.widget_navi_back_button);
        }
        this.fON = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.topic_detail_share_layout, this);
        al.c(this.fON, d.f.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, d.C0277d.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(d.e.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dbq = (NoNetworkView) findViewById(d.g.activity_topic_detail_no_network_view);
        this.dbq.a(this.emy);
        this.fOR = findViewById(d.g.pb_editor_tool_comment);
        this.fOS = (TextView) findViewById(d.g.topic_editor_tool_comment_reply_text);
        this.fOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.bnj();
            }
        });
        this.fOT = (TextView) findViewById(d.g.editor_tool_opinion_text_view);
        this.fOQ = findViewById(d.g.activity_topic_detail_editor);
        R(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.fOU.alP(), layoutParams);
        this.fOW = new com.baidu.tieba.write.b();
        this.fOV = findViewById(d.g.activity_topic_detail_editor_top);
        this.fxw = (BdTypeRecyclerView) findViewById(d.g.activity_topic_detail_list);
        this.fxw.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fxw.setFadingEdgeLength(0);
        this.fxw.setOverScrollMode(2);
        this.fxw.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fxw.addOnScrollListener(this.mScrollListener);
        al.l(this.fxw, d.C0277d.cp_bg_line_d);
        this.fOP = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fxw);
        this.fOO = new TopicDetailHeadView(getContext());
        this.fOO.fOK.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void sD(int i) {
                TopicDetailView.this.sC(i);
            }
        });
        if (this.cXp == null) {
            this.dbr = new PbListView(this.mPageContext.getPageActivity());
            this.dbr.getView();
        }
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.setHeight(l.h(this.mPageContext.getPageActivity(), d.e.tbds182));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.dbr.ia(al.getColor(d.C0277d.cp_bg_line_d));
        this.dbr.hW(al.getColor(d.C0277d.cp_bg_line_c));
        this.dbr.setText(getResources().getString(d.j.list_has_no_more));
        this.dbr.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.fOZ == null) {
            this.fOZ = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.fOZ.i(this.mPageContext.getUniqueId());
        }
    }

    private void R(Bundle bundle) {
        this.fOU = (a) new b().dd(getContext());
        if (this.fOU != null) {
            this.fOU.a(this.mPageContext);
            this.fOU.b(this.fPd);
            this.fOU.a(this.cko);
            this.fOU.alP().eH(true);
            this.fOU.a((BaseActivity) getContext(), bundle);
            this.fOU.amM();
            this.fOU.alP().setId(d.g.topic_editor);
            this.fOX = this.fOU.bni().getInputView();
            this.fOX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.fOW != null) {
                        if (!TopicDetailView.this.fOW.cnZ()) {
                            TopicDetailView.this.kt(false);
                        }
                        TopicDetailView.this.fOW.qV(false);
                    }
                }
            });
        }
    }

    public void kt(boolean z) {
        if (this.fOX != null && this.fOX.getText() != null) {
            int selectionEnd = this.fOX.getSelectionEnd();
            SpannableStringBuilder b = this.fOW.b(this.fOX.getText());
            if (b != null) {
                this.fOW.qV(true);
                this.fOX.setText(b);
                if (z && this.fOW.cnX() >= 0) {
                    this.fOX.requestFocus();
                    this.fOX.setSelection(this.fOW.cnX());
                } else {
                    this.fOX.setSelection(selectionEnd);
                }
                this.fOW.qU(this.fOW.cnX() >= 0);
            }
        }
    }

    public void bnj() {
        if (bc.cZ(getContext())) {
            this.fOU.amP();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(int i) {
        this.fOY = i;
        this.fOT.setVisibility(0);
        if (i == 1) {
            this.fOT.setText(d.j.topic_detail_pk_support);
            al.k(this.fOT, d.f.topic_discuss_support_bg);
        } else if (i == 2) {
            this.fOT.setText(d.j.topic_detail_pk_oppose);
            al.k(this.fOT, d.f.topic_discuss_oppose_bg);
        } else {
            this.fOT.setText(d.j.topic_detail_pk_chigua);
            al.k(this.fOT, d.f.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.fOT.setTextColor(-2130706433);
        } else {
            al.j(this.fOT, d.C0277d.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int h;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aCs();
            } else if (!this.mHasMore) {
                aCs();
            } else {
                aCr();
            }
            if (!StringUtils.isNull(aVar.bAp)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(d.j.daily_topic_name), ap.g(aVar.bAp, 14, "...")));
            }
            this.fOO.setData(aVar.fOc);
            this.fxw.addHeaderView(this.fOO);
            this.fOP.setData(aVar.mDataList);
            if (this.mTopicDetailData.fOc.fOh != null) {
                if (this.mTopicDetailData.fOc.fOh.fPF.fPL) {
                    sC(1);
                } else if (this.mTopicDetailData.fOc.fOh.fPG.fPL) {
                    sC(2);
                } else {
                    sC(0);
                }
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds130);
            } else {
                h = l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds50);
                this.fOT.setVisibility(8);
            }
            this.fOS.setPadding(h, 0, 0, 0);
            bnk();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aCs();
        } else {
            aCr();
        }
        if (i == 0 && list != null && !v.T(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).fOn = this.mTopicDetailData.bnd();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fxw.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        this.fxw.setNextPage(null);
    }

    public void aCr() {
        this.mHasMore = true;
        this.fxw.setNextPage(this.dbr);
        this.dbr.aez();
    }

    public void aCs() {
        this.fxw.setNextPage(this.dbr);
        this.dbr.aeA();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fax) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.fON && this.mTopicDetailData.topicId > 0) {
            aeU();
            TiebaStatic.log(new am("c13364").bJ("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void aeU() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bAp;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(d.j.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.fOb) ? null : Uri.parse(this.mTopicDetailData.fOb);
            final com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = str;
            dVar.content = str2;
            dVar.linkUrl = str3;
            dVar.cbr = true;
            dVar.extData = valueOf;
            dVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            bnk();
            al.j(this.mNavigationBar.mCenterText, d.C0277d.cp_btn_a);
            al.k(this.fOR, d.C0277d.cp_cont_g);
            al.j(this.fOS, d.C0277d.cp_cont_d);
            al.k(this.fOS, d.f.topic_discuss_input_bg);
            sC(this.fOY);
            al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
            if (this.fON != null) {
                al.c(this.fON, d.f.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dbq != null) {
                this.dbq.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.cXp != null) {
                this.cXp.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.fOU != null && this.fOU.alP() != null) {
                this.fOU.alP().onChangeSkinType(this.mSkinType);
            }
            if (this.dbr != null) {
                this.dbr.hZ(d.C0277d.cp_cont_e);
                this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_e));
                this.dbr.ia(al.getColor(d.C0277d.cp_bg_line_d));
                this.dbr.hW(al.getColor(d.C0277d.cp_bg_line_c));
            }
            if (this.fOO != null) {
                this.fOO.onChangeSkinType();
            }
            if (this.fOP != null) {
                this.fOP.notifyDataSetChanged();
            }
            al.l(this.fxw, d.C0277d.cp_bg_line_d);
        }
    }

    public void cE(boolean z) {
        if (!aXo()) {
            if (this.cXp == null) {
                this.cXp = new g(getContext());
                this.cXp.onChangeSkinType();
            }
            this.cXp.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.cXp != null) {
            this.cXp.dettachView(this);
            this.cXp = null;
        }
    }

    public boolean aXo() {
        if (this.cXp != null) {
            return this.cXp.isViewAttached();
        }
        return false;
    }

    public void iD(boolean z) {
        if (!aXp()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kM() && TopicDetailView.this.fOM != null) {
                            TopicDetailView.this.fOM.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.jQ(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.any();
            this.fxw.setVisibility(8);
        }
    }

    public void aBq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fxw.setVisibility(0);
    }

    public boolean aXp() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        this.fxw.setOnSrollToBottomListener(null);
        if (this.dbq != null) {
            this.dbq.b(this.emy);
        }
        if (this.fOU != null) {
            this.fOU.onDestory();
        }
        if (this.fPa != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fPa);
        }
        hideLoadingView();
        aBq();
    }

    public a getEditor() {
        return this.fOU;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.fOV != null) {
            ViewGroup.LayoutParams layoutParams = this.fOV.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.fOU.alP().isVisible()) {
                    layoutParams2.addRule(2, this.fOU.alP().getId());
                } else {
                    layoutParams2.addRule(2, this.fOQ.getId());
                }
                this.fOV.setLayoutParams(layoutParams2);
            }
        }
    }

    public void at(bg bgVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<m> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            m next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.fOk = cVar.fOk;
            cVar2.threadData = bgVar;
            cVar2.fOm = 2;
            cVar2.fOl = this.fOY;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.fOn = this.mTopicDetailData.bnd();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.fOP.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnk() {
        if (this.mTopicDetailData != null && this.fOO != null) {
            if (this.fPb > this.fPc) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(bnl()));
                return;
            }
            al.l(this.mNavigationBar.getBarBgView(), d.C0277d.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap bnl() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.fOO.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.oy();
        } else {
            drawingCache = this.fOO.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
