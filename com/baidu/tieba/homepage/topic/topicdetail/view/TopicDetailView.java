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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e WQ;
    private com.baidu.tbadk.editortools.pb.b fwC;
    private g gAg;
    private NoNetworkView.a gpz;
    private NoNetworkView grf;
    private PbListView grg;
    private View iVw;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jYA;
    a.RunnableC0765a jYB;
    private int jYC;
    private int jYD;
    private NewWriteModel.d jYE;
    private com.baidu.tieba.homepage.topic.topicdetail.a jYn;
    private ImageView jYo;
    private TopicDetailHeadView jYp;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jYq;
    private View jYr;
    private View jYs;
    private TextView jYt;
    private TextView jYu;
    private a jYv;
    private View jYw;
    private com.baidu.tieba.write.c jYx;
    private EditText jYy;
    private int jYz;
    private BdTypeRecyclerView jzI;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.b.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.jYs = null;
        this.jYt = null;
        this.jYu = null;
        this.mHasMore = true;
        this.jYC = 0;
        this.jYD = 44;
        this.gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jYn != null) {
                    TopicDetailView.this.jYn.loadData();
                }
            }
        };
        this.fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bCR() {
                if (TopicDetailView.this.jYx.dYp()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jYx.dYr());
                    TopicDetailView.this.rM(true);
                    return true;
                }
                return false;
            }
        };
        this.jYE = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jYv != null && TopicDetailView.this.jYv.bCn() != null) {
                    TopicDetailView.this.jYv.bCn().hide();
                }
                if (z) {
                    TopicDetailView.this.jYx.VA(null);
                    TopicDetailView.this.jYx.bn(null);
                    TopicDetailView.this.jYx.zb(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jYB = TopicDetailView.this.jYA.z(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jYB, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jYx.bn(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jYx.VA(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jYx.dYn())) {
                        TopicDetailView.this.rM(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jYv != null) {
                    TopicDetailView.this.jYv.bDv();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jzI, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jYC += i2;
                TopicDetailView.this.cQZ();
            }
        };
        this.WQ = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bTb();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gC(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jXO);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jYn = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.iVw == null) {
            this.iVw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVw.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.iVw.findViewById(R.id.widget_navi_back_button);
        }
        this.jYo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.grf = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.grf.a(this.gpz);
        this.jYs = findViewById(R.id.pb_editor_tool_comment);
        this.jYt = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jYt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cQY();
            }
        });
        this.jYu = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jYr = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jYv.bCn(), layoutParams);
        this.jYx = new com.baidu.tieba.write.c();
        this.jYw = findViewById(R.id.activity_topic_detail_editor_top);
        this.jzI = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jzI.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jzI.setFadingEdgeLength(0);
        this.jzI.setOverScrollMode(2);
        this.jzI.setOnSrollToBottomListener(this.WQ);
        this.jzI.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jzI, R.color.CAM_X0201);
        this.jYq = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.jzI);
        this.jYp = new TopicDetailHeadView(getContext());
        this.jYp.jYl.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Df(int i) {
                TopicDetailView.this.De(i);
            }
        });
        if (this.gAg == null) {
            this.grg = new PbListView(this.mPageContext.getPageActivity());
            this.grg.getView();
        }
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.grg.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.grg.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.grg.setText(getResources().getString(R.string.list_has_no_more));
        this.grg.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jYA == null) {
            this.jYA = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jYA.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.jYv = (a) new b().eN(getContext());
        if (this.jYv != null) {
            this.jYv.a(this.mPageContext);
            this.jYv.b(this.jYE);
            this.jYv.a(this.fwC);
            this.jYv.bCn().ks(true);
            this.jYv.bCn().setBarBackgroundColorId(R.color.CAM_X0207);
            this.jYv.a((BaseActivity) getContext(), bundle);
            this.jYv.bDv();
            this.jYv.bCn().setId(R.id.topic_editor);
            this.jYy = this.jYv.cQX().getInputView();
            this.jYy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jYx != null) {
                        if (!TopicDetailView.this.jYx.dYq()) {
                            TopicDetailView.this.rM(false);
                        }
                        TopicDetailView.this.jYx.zc(false);
                    }
                }
            });
        }
    }

    public void rM(boolean z) {
        if (this.jYy != null && this.jYy.getText() != null) {
            int selectionEnd = this.jYy.getSelectionEnd();
            SpannableStringBuilder c = this.jYx.c(this.jYy.getText());
            if (c != null) {
                this.jYx.zc(true);
                this.jYy.setText(c);
                if (z && this.jYx.dYo() >= 0) {
                    this.jYy.requestFocus();
                    this.jYy.setSelection(this.jYx.dYo());
                } else {
                    this.jYy.setSelection(selectionEnd);
                }
                this.jYx.zb(this.jYx.dYo() >= 0);
            }
        }
    }

    public void cQY() {
        if (bh.checkUpIsLogin(getContext())) {
            this.jYv.bDy();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dY("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De(int i) {
        this.jYz = i;
        this.jYu.setVisibility(0);
        if (i == 1) {
            this.jYu.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jYu, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jYu.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jYu, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jYu.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jYu, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jYu.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jYu, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                Ya();
            } else if (!this.mHasMore) {
                Ya();
            } else {
                XZ();
            }
            if (!StringUtils.isNull(aVar.eIa)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), au.cutChineseAndEnglishWithSuffix(aVar.eIa, 14, StringHelper.STRING_MORE)));
            }
            this.jYp.setData(aVar.jXG);
            this.jzI.addHeaderView(this.jYp);
            this.jYq.setData(aVar.mDataList);
            if (this.mTopicDetailData.jXG.jXL != null) {
                if (this.mTopicDetailData.jXG.jXL.jZg.jZm) {
                    De(1);
                } else if (this.mTopicDetailData.jXG.jXL.jZh.jZm) {
                    De(2);
                } else {
                    De(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jYu.setVisibility(8);
            }
            this.jYt.setPadding(dimens, 0, 0, 0);
            cQZ();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            Ya();
        } else {
            XZ();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jXQ = this.mTopicDetailData.cQT();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jzI.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTb() {
        this.jzI.setNextPage(null);
    }

    public void XZ() {
        this.mHasMore = true;
        this.jzI.setNextPage(this.grg);
        this.grg.startLoadData();
    }

    public void Ya() {
        this.jzI.setNextPage(this.grg);
        this.grg.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVw) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jYo && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bvJ();
            TiebaStatic.log(new ar("c13364").dY("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bvJ() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eIa;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jXF) ? null : Uri.parse(this.mTopicDetailData.jXF);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fnu = true;
            shareItem.extData = valueOf;
            shareItem.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            cQZ();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.jYs, R.color.CAM_X0207);
            ap.setViewTextColor(this.jYt, R.color.CAM_X0109);
            this.jYt.setBackgroundDrawable(ap.aR(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            De(this.jYz);
            SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jYo != null) {
                SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.grf != null) {
                this.grf.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gAg != null) {
                this.gAg.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jYv != null && this.jYv.bCn() != null) {
                this.jYv.bCn().onChangeSkinType(this.mSkinType);
            }
            if (this.grg != null) {
                this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
                this.grg.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.grg.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.grg.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.jYp != null) {
                this.jYp.onChangeSkinType();
            }
            if (this.jYq != null) {
                this.jYq.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jzI, R.color.CAM_X0205);
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jYn != null) {
                            TopicDetailView.this.jYn.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jzI.setVisibility(8);
            SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jzI.setVisibility(0);
        SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cqA() {
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
        this.jzI.setOnSrollToBottomListener(null);
        if (this.grf != null) {
            this.grf.b(this.gpz);
        }
        if (this.jYv != null) {
            this.jYv.onDestory();
        }
        if (this.jYB != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jYB);
        }
        hideLoadingView();
        Yb();
    }

    public a getEditor() {
        return this.jYv;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jYw != null) {
            ViewGroup.LayoutParams layoutParams = this.jYw.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jYv.bCn().isVisible()) {
                    layoutParams2.addRule(2, this.jYv.bCn().getId());
                } else {
                    layoutParams2.addRule(2, this.jYr.getId());
                }
                this.jYw.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aF(by byVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.b.c cVar;
        int i2 = 0;
        Iterator<q> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            q next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.b.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.b.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.b.c();
            cVar2.jXO = cVar.jXO;
            cVar2.eCR = byVar;
            cVar2.source = 2;
            cVar2.jXP = this.jYz;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jXQ = this.mTopicDetailData.cQT();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jYq.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQZ() {
        if (this.mTopicDetailData != null && this.jYp != null) {
            if (this.jYC > this.jYD) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cRa()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cRa() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jYp.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jYp.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
