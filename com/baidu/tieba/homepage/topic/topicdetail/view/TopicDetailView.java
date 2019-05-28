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
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tbadk.editortools.pb.b csx;
    private g dhY;
    private NoNetworkView dlX;
    private PbListView dlY;
    private NoNetworkView.a eCl;
    private BdTypeRecyclerView fOr;
    private View fqN;
    private com.baidu.tieba.homepage.topic.topicdetail.a gfU;
    private ImageView gfV;
    private TopicDetailHeadView gfW;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b gfX;
    private View gfY;
    private View gfZ;
    private TextView gga;
    private TextView ggb;
    private a ggc;
    private View ggd;
    private com.baidu.tieba.write.b gge;
    private EditText ggf;
    private int ggg;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a ggh;
    a.RunnableC0322a ggi;
    private int ggj;
    private int ggk;
    private NewWriteModel.d ggl;
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
        this.gfZ = null;
        this.gga = null;
        this.ggb = null;
        this.mHasMore = true;
        this.ggj = 0;
        this.ggk = 44;
        this.eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.gfU != null) {
                    TopicDetailView.this.gfU.loadData();
                }
            }
        };
        this.csx = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean arq() {
                if (TopicDetailView.this.gge.cwg()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.gge.cwi());
                    TopicDetailView.this.lj(true);
                    return true;
                }
                return false;
            }
        };
        this.ggl = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.ggc != null && TopicDetailView.this.ggc.aqS() != null) {
                    TopicDetailView.this.ggc.aqS().hide();
                }
                if (z) {
                    TopicDetailView.this.gge.FE(null);
                    TopicDetailView.this.gge.aI(null);
                    TopicDetailView.this.gge.rJ(false);
                    if (postWriteCallBackData != null) {
                        long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                        long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                        if (c != 0 && c2 != 0) {
                            TopicDetailView.this.ggi = TopicDetailView.this.ggh.p(c, c2);
                            com.baidu.adp.lib.g.e.iB().postDelayed(TopicDetailView.this.ggi, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.gge.aI(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.gge.FE(postWriteCallBackData.getErrorString());
                    if (!v.aa(TopicDetailView.this.gge.cwe())) {
                        TopicDetailView.this.lj(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.ggc != null) {
                    TopicDetailView.this.ggc.arP();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.fOr, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.ggj += i2;
                TopicDetailView.this.buP();
            }
        };
        this.mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.ki()) {
                        TopicDetailView.this.aIJ();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).dk(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).gfu);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.gfU = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.fqN == null) {
            this.fqN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqN.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.fqN.findViewById(R.id.widget_navi_back_button);
        }
        this.gfV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        al.c(this.gfV, (int) R.drawable.selector_topbar_share_white);
        al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.dlX = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.dlX.a(this.eCl);
        this.gfZ = findViewById(R.id.pb_editor_tool_comment);
        this.gga = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.gga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.buO();
            }
        });
        this.ggb = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.gfY = findViewById(R.id.activity_topic_detail_editor);
        S(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.ggc.aqS(), layoutParams);
        this.gge = new com.baidu.tieba.write.b();
        this.ggd = findViewById(R.id.activity_topic_detail_editor_top);
        this.fOr = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.fOr.setLayoutManager(new LinearLayoutManager(getContext()));
        this.fOr.setFadingEdgeLength(0);
        this.fOr.setOverScrollMode(2);
        this.fOr.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fOr.addOnScrollListener(this.mScrollListener);
        al.l(this.fOr, R.color.cp_bg_line_d);
        this.gfX = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.fOr);
        this.gfW = new TopicDetailHeadView(getContext());
        this.gfW.gfS.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void tK(int i) {
                TopicDetailView.this.tJ(i);
            }
        });
        if (this.dhY == null) {
            this.dlY = new PbListView(this.mPageContext.getPageActivity());
            this.dlY.getView();
        }
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_e));
        this.dlY.iO(al.getColor(R.color.cp_bg_line_d));
        this.dlY.iK(al.getColor(R.color.cp_bg_line_c));
        this.dlY.setText(getResources().getString(R.string.list_has_no_more));
        this.dlY.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.ggh == null) {
            this.ggh = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.ggh.i(this.mPageContext.getUniqueId());
        }
    }

    private void S(Bundle bundle) {
        this.ggc = (a) new b().cJ(getContext());
        if (this.ggc != null) {
            this.ggc.a(this.mPageContext);
            this.ggc.b(this.ggl);
            this.ggc.a(this.csx);
            this.ggc.aqS().fd(true);
            this.ggc.a((BaseActivity) getContext(), bundle);
            this.ggc.arP();
            this.ggc.aqS().setId(R.id.topic_editor);
            this.ggf = this.ggc.buN().getInputView();
            this.ggf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.gge != null) {
                        if (!TopicDetailView.this.gge.cwh()) {
                            TopicDetailView.this.lj(false);
                        }
                        TopicDetailView.this.gge.rK(false);
                    }
                }
            });
        }
    }

    public void lj(boolean z) {
        if (this.ggf != null && this.ggf.getText() != null) {
            int selectionEnd = this.ggf.getSelectionEnd();
            SpannableStringBuilder b = this.gge.b(this.ggf.getText());
            if (b != null) {
                this.gge.rK(true);
                this.ggf.setText(b);
                if (z && this.gge.cwf() >= 0) {
                    this.ggf.requestFocus();
                    this.ggf.setSelection(this.gge.cwf());
                } else {
                    this.ggf.setSelection(selectionEnd);
                }
                this.gge.rJ(this.gge.cwf() >= 0);
            }
        }
    }

    public void buO() {
        if (bc.cE(getContext())) {
            this.ggc.arS();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new am("c13359").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        this.ggg = i;
        this.ggb.setVisibility(0);
        if (i == 1) {
            this.ggb.setText(R.string.topic_detail_pk_support);
            al.k(this.ggb, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.ggb.setText(R.string.topic_detail_pk_oppose);
            al.k(this.ggb, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.ggb.setText(R.string.topic_detail_pk_chigua);
            al.k(this.ggb, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1) {
            this.ggb.setTextColor(-2130706433);
        } else {
            al.j(this.ggb, R.color.cp_btn_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int g;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                aII();
            } else if (!this.mHasMore) {
                aII();
            } else {
                aIH();
            }
            if (!StringUtils.isNull(aVar.bHC)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), ap.j(aVar.bHC, 14, "...")));
            }
            this.gfW.setData(aVar.gfm);
            this.fOr.addHeaderView(this.gfW);
            this.gfX.setData(aVar.mDataList);
            if (this.mTopicDetailData.gfm.gfr != null) {
                if (this.mTopicDetailData.gfm.gfr.ggO.ggU) {
                    tJ(1);
                } else if (this.mTopicDetailData.gfm.gfr.ggP.ggU) {
                    tJ(2);
                } else {
                    tJ(0);
                }
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
            } else {
                g = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.ggb.setVisibility(8);
            }
            this.gga.setPadding(g, 0, 0, 0);
            buP();
        }
    }

    public void setNextData(int i, boolean z, List<m> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            aII();
        } else {
            aIH();
        }
        if (i == 0 && list != null && !v.aa(list)) {
            for (m mVar : list) {
                if (mVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) mVar).gfw = this.mTopicDetailData.buI();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.fOr.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIJ() {
        this.fOr.setNextPage(null);
    }

    public void aIH() {
        this.mHasMore = true;
        this.fOr.setNextPage(this.dlY);
        this.dlY.ajy();
    }

    public void aII() {
        this.fOr.setNextPage(this.dlY);
        this.dlY.ajz();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqN) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.gfV && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            ajT();
            TiebaStatic.log(new am("c13364").bT("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void ajT() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.bHC;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.gfl) ? null : Uri.parse(this.mTopicDetailData.gfl);
            final com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = str;
            eVar.content = str2;
            eVar.linkUrl = str3;
            eVar.cjs = true;
            eVar.extData = valueOf;
            eVar.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), eVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.aR(eVar.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            buP();
            al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
            al.k(this.gfZ, R.color.cp_cont_g);
            al.j(this.gga, R.color.cp_cont_d);
            al.k(this.gga, R.drawable.topic_discuss_input_bg);
            tJ(this.ggg);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
            if (this.gfV != null) {
                al.c(this.gfV, (int) R.drawable.selector_topbar_share_white);
            }
            if (this.mPageContext != null && this.dlX != null) {
                this.dlX.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.ggc != null && this.ggc.aqS() != null) {
                this.ggc.aqS().onChangeSkinType(this.mSkinType);
            }
            if (this.dlY != null) {
                this.dlY.iN(R.color.cp_cont_e);
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_e));
                this.dlY.iO(al.getColor(R.color.cp_bg_line_d));
                this.dlY.iK(al.getColor(R.color.cp_bg_line_c));
            }
            if (this.gfW != null) {
                this.gfW.onChangeSkinType();
            }
            if (this.gfX != null) {
                this.gfX.notifyDataSetChanged();
            }
            al.l(this.fOr, R.color.cp_bg_line_d);
        }
    }

    public void cV(boolean z) {
        if (!beF()) {
            if (this.dhY == null) {
                this.dhY = new g(getContext());
                this.dhY.onChangeSkinType();
            }
            this.dhY.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this);
            this.dhY = null;
        }
    }

    public boolean beF() {
        if (this.dhY != null) {
            return this.dhY.isViewAttached();
        }
        return false;
    }

    public void jk(boolean z) {
        if (!beG()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jG() && TopicDetailView.this.gfU != null) {
                            TopicDetailView.this.gfU.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.kE(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds380));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.asB();
            this.fOr.setVisibility(8);
            al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
        }
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.fOr.setVisibility(0);
        al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
    }

    public boolean beG() {
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
        this.fOr.setOnSrollToBottomListener(null);
        if (this.dlX != null) {
            this.dlX.b(this.eCl);
        }
        if (this.ggc != null) {
            this.ggc.onDestory();
        }
        if (this.ggi != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.ggi);
        }
        hideLoadingView();
        aHK();
    }

    public a getEditor() {
        return this.ggc;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.ggd != null) {
            ViewGroup.LayoutParams layoutParams = this.ggd.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.ggc.aqS().isVisible()) {
                    layoutParams2.addRule(2, this.ggc.aqS().getId());
                } else {
                    layoutParams2.addRule(2, this.gfY.getId());
                }
                this.ggd.setLayoutParams(layoutParams2);
            }
        }
    }

    public void ar(bg bgVar) {
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
            cVar2.gfu = cVar.gfu;
            cVar2.threadData = bgVar;
            cVar2.source = 2;
            cVar2.gfv = this.ggg;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.gfw = this.mTopicDetailData.buI();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.gfX.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buP() {
        if (this.mTopicDetailData != null && this.gfW != null) {
            if (this.ggj > this.ggk) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(buQ()));
                return;
            }
            al.l(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap buQ() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.gfW.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.ns();
        } else {
            drawingCache = this.gfW.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
