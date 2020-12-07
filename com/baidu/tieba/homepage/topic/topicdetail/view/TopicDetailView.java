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
    private g gAe;
    private NoNetworkView.a gpx;
    private NoNetworkView grd;
    private PbListView gre;
    private View iVu;
    private int jYA;
    private int jYB;
    private NewWriteModel.d jYC;
    private com.baidu.tieba.homepage.topic.topicdetail.a jYl;
    private ImageView jYm;
    private TopicDetailHeadView jYn;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jYo;
    private View jYp;
    private View jYq;
    private TextView jYr;
    private TextView jYs;
    private a jYt;
    private View jYu;
    private com.baidu.tieba.write.c jYv;
    private EditText jYw;
    private int jYx;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jYy;
    a.RunnableC0765a jYz;
    private BdTypeRecyclerView jzG;
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
        this.jYq = null;
        this.jYr = null;
        this.jYs = null;
        this.mHasMore = true;
        this.jYA = 0;
        this.jYB = 44;
        this.gpx = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jYl != null) {
                    TopicDetailView.this.jYl.loadData();
                }
            }
        };
        this.fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bCR() {
                if (TopicDetailView.this.jYv.dYo()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jYv.dYq());
                    TopicDetailView.this.rM(true);
                    return true;
                }
                return false;
            }
        };
        this.jYC = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jYt != null && TopicDetailView.this.jYt.bCn() != null) {
                    TopicDetailView.this.jYt.bCn().hide();
                }
                if (z) {
                    TopicDetailView.this.jYv.VA(null);
                    TopicDetailView.this.jYv.bn(null);
                    TopicDetailView.this.jYv.zb(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jYz = TopicDetailView.this.jYy.z(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jYz, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jYv.bn(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jYv.VA(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jYv.dYm())) {
                        TopicDetailView.this.rM(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jYt != null) {
                    TopicDetailView.this.jYt.bDv();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jzG, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jYA += i2;
                TopicDetailView.this.cQY();
            }
        };
        this.WQ = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bTa();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gC(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jXM);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jYl = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.iVu == null) {
            this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVu.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.iVu.findViewById(R.id.widget_navi_back_button);
        }
        this.jYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.grd = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.grd.a(this.gpx);
        this.jYq = findViewById(R.id.pb_editor_tool_comment);
        this.jYr = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jYr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cQX();
            }
        });
        this.jYs = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jYp = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jYt.bCn(), layoutParams);
        this.jYv = new com.baidu.tieba.write.c();
        this.jYu = findViewById(R.id.activity_topic_detail_editor_top);
        this.jzG = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jzG.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jzG.setFadingEdgeLength(0);
        this.jzG.setOverScrollMode(2);
        this.jzG.setOnSrollToBottomListener(this.WQ);
        this.jzG.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jzG, R.color.CAM_X0201);
        this.jYo = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.jzG);
        this.jYn = new TopicDetailHeadView(getContext());
        this.jYn.jYj.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Df(int i) {
                TopicDetailView.this.De(i);
            }
        });
        if (this.gAe == null) {
            this.gre = new PbListView(this.mPageContext.getPageActivity());
            this.gre.getView();
        }
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.gre.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.gre.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.gre.setText(getResources().getString(R.string.list_has_no_more));
        this.gre.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jYy == null) {
            this.jYy = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jYy.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.jYt = (a) new b().eN(getContext());
        if (this.jYt != null) {
            this.jYt.a(this.mPageContext);
            this.jYt.b(this.jYC);
            this.jYt.a(this.fwC);
            this.jYt.bCn().ks(true);
            this.jYt.bCn().setBarBackgroundColorId(R.color.CAM_X0207);
            this.jYt.a((BaseActivity) getContext(), bundle);
            this.jYt.bDv();
            this.jYt.bCn().setId(R.id.topic_editor);
            this.jYw = this.jYt.cQW().getInputView();
            this.jYw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jYv != null) {
                        if (!TopicDetailView.this.jYv.dYp()) {
                            TopicDetailView.this.rM(false);
                        }
                        TopicDetailView.this.jYv.zc(false);
                    }
                }
            });
        }
    }

    public void rM(boolean z) {
        if (this.jYw != null && this.jYw.getText() != null) {
            int selectionEnd = this.jYw.getSelectionEnd();
            SpannableStringBuilder c = this.jYv.c(this.jYw.getText());
            if (c != null) {
                this.jYv.zc(true);
                this.jYw.setText(c);
                if (z && this.jYv.dYn() >= 0) {
                    this.jYw.requestFocus();
                    this.jYw.setSelection(this.jYv.dYn());
                } else {
                    this.jYw.setSelection(selectionEnd);
                }
                this.jYv.zb(this.jYv.dYn() >= 0);
            }
        }
    }

    public void cQX() {
        if (bh.checkUpIsLogin(getContext())) {
            this.jYt.bDy();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dY("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void De(int i) {
        this.jYx = i;
        this.jYs.setVisibility(0);
        if (i == 1) {
            this.jYs.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jYs, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jYs.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jYs, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jYs.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jYs, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jYs.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jYs, R.color.CAM_X0101);
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
            this.jYn.setData(aVar.jXE);
            this.jzG.addHeaderView(this.jYn);
            this.jYo.setData(aVar.mDataList);
            if (this.mTopicDetailData.jXE.jXJ != null) {
                if (this.mTopicDetailData.jXE.jXJ.jZe.jZk) {
                    De(1);
                } else if (this.mTopicDetailData.jXE.jXJ.jZf.jZk) {
                    De(2);
                } else {
                    De(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jYs.setVisibility(8);
            }
            this.jYr.setPadding(dimens, 0, 0, 0);
            cQY();
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
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jXO = this.mTopicDetailData.cQS();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jzG.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTa() {
        this.jzG.setNextPage(null);
    }

    public void XZ() {
        this.mHasMore = true;
        this.jzG.setNextPage(this.gre);
        this.gre.startLoadData();
    }

    public void Ya() {
        this.jzG.setNextPage(this.gre);
        this.gre.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVu) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jYm && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
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
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jXD) ? null : Uri.parse(this.mTopicDetailData.jXD);
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
            cQY();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.jYq, R.color.CAM_X0207);
            ap.setViewTextColor(this.jYr, R.color.CAM_X0109);
            this.jYr.setBackgroundDrawable(ap.aR(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            De(this.jYx);
            SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jYm != null) {
                SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.grd != null) {
                this.grd.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gAe != null) {
                this.gAe.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jYt != null && this.jYt.bCn() != null) {
                this.jYt.bCn().onChangeSkinType(this.mSkinType);
            }
            if (this.gre != null) {
                this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gre.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.gre.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.gre.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.jYn != null) {
                this.jYn.onChangeSkinType();
            }
            if (this.jYo != null) {
                this.jYo.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jzG, R.color.CAM_X0205);
        }
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void px(boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jYl != null) {
                            TopicDetailView.this.jYl.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jzG.setVisibility(8);
            SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jzG.setVisibility(0);
        SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cqz() {
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
        this.jzG.setOnSrollToBottomListener(null);
        if (this.grd != null) {
            this.grd.b(this.gpx);
        }
        if (this.jYt != null) {
            this.jYt.onDestory();
        }
        if (this.jYz != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jYz);
        }
        hideLoadingView();
        Yb();
    }

    public a getEditor() {
        return this.jYt;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jYu != null) {
            ViewGroup.LayoutParams layoutParams = this.jYu.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jYt.bCn().isVisible()) {
                    layoutParams2.addRule(2, this.jYt.bCn().getId());
                } else {
                    layoutParams2.addRule(2, this.jYp.getId());
                }
                this.jYu.setLayoutParams(layoutParams2);
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
            cVar2.jXM = cVar.jXM;
            cVar2.eCR = byVar;
            cVar2.source = 2;
            cVar2.jXN = this.jYx;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jXO = this.mTopicDetailData.cQS();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jYo.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQY() {
        if (this.mTopicDetailData != null && this.jYn != null) {
            if (this.jYA > this.jYB) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cQZ()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cQZ() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jYn.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jYn.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
