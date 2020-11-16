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
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e VT;
    private com.baidu.tbadk.editortools.pb.b foX;
    private NoNetworkView.a ghn;
    private NoNetworkView giU;
    private PbListView giV;
    private g grV;
    private View iKB;
    private com.baidu.tieba.homepage.topic.topicdetail.a jKI;
    private ImageView jKJ;
    private TopicDetailHeadView jKK;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b jKL;
    private View jKM;
    private View jKN;
    private TextView jKO;
    private TextView jKP;
    private a jKQ;
    private View jKR;
    private com.baidu.tieba.write.c jKS;
    private EditText jKT;
    private int jKU;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a jKV;
    a.RunnableC0749a jKW;
    private int jKX;
    private int jKY;
    private NewWriteModel.d jKZ;
    private BdTypeRecyclerView jmd;
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
        this.jKN = null;
        this.jKO = null;
        this.jKP = null;
        this.mHasMore = true;
        this.jKX = 0;
        this.jKY = 44;
        this.ghn = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.jKI != null) {
                    TopicDetailView.this.jKI.loadData();
                }
            }
        };
        this.foX = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bzr() {
                if (TopicDetailView.this.jKS.dSU()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.jKS.dSW());
                    TopicDetailView.this.rk(true);
                    return true;
                }
                return false;
            }
        };
        this.jKZ = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.jKQ != null && TopicDetailView.this.jKQ.byN() != null) {
                    TopicDetailView.this.jKQ.byN().hide();
                }
                if (z) {
                    TopicDetailView.this.jKS.Ul(null);
                    TopicDetailView.this.jKS.bl(null);
                    TopicDetailView.this.jKS.yw(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.jKW = TopicDetailView.this.jKV.A(j, j2);
                            com.baidu.adp.lib.f.e.mY().postDelayed(TopicDetailView.this.jKW, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.jKS.bl(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.jKS.Ul(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.jKS.dSS())) {
                        TopicDetailView.this.rk(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.jKQ != null) {
                    TopicDetailView.this.jKQ.bzV();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jmd, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.jKX += i2;
                TopicDetailView.this.cLK();
            }
        };
        this.VT = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bPp();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).fX(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).jKj);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jKI = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.iKB == null) {
            this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iKB.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.iKB.findViewById(R.id.widget_navi_back_button);
        }
        this.jKJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.giU = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.giU.a(this.ghn);
        this.jKN = findViewById(R.id.pb_editor_tool_comment);
        this.jKO = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.jKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cLJ();
            }
        });
        this.jKP = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.jKM = findViewById(R.id.activity_topic_detail_editor);
        ar(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.jKQ.byN(), layoutParams);
        this.jKS = new com.baidu.tieba.write.c();
        this.jKR = findViewById(R.id.activity_topic_detail_editor_top);
        this.jmd = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jmd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jmd.setFadingEdgeLength(0);
        this.jmd.setOverScrollMode(2);
        this.jmd.setOnSrollToBottomListener(this.VT);
        this.jmd.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jmd, R.color.CAM_X0201);
        this.jKL = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.jmd);
        this.jKK = new TopicDetailHeadView(getContext());
        this.jKK.jKG.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Cq(int i) {
                TopicDetailView.this.Cp(i);
            }
        });
        if (this.grV == null) {
            this.giV = new PbListView(this.mPageContext.getPageActivity());
            this.giV.getView();
        }
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.giV.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.giV.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.giV.setText(getResources().getString(R.string.list_has_no_more));
        this.giV.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.jKV == null) {
            this.jKV = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.jKV.l(this.mPageContext.getUniqueId());
        }
    }

    private void ar(Bundle bundle) {
        this.jKQ = (a) new b().ei(getContext());
        if (this.jKQ != null) {
            this.jKQ.a(this.mPageContext);
            this.jKQ.b(this.jKZ);
            this.jKQ.a(this.foX);
            this.jKQ.byN().kc(true);
            this.jKQ.byN().setBarBackgroundColorId(R.color.CAM_X0207);
            this.jKQ.a((BaseActivity) getContext(), bundle);
            this.jKQ.bzV();
            this.jKQ.byN().setId(R.id.topic_editor);
            this.jKT = this.jKQ.cLI().getInputView();
            this.jKT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.jKS != null) {
                        if (!TopicDetailView.this.jKS.dSV()) {
                            TopicDetailView.this.rk(false);
                        }
                        TopicDetailView.this.jKS.yx(false);
                    }
                }
            });
        }
    }

    public void rk(boolean z) {
        if (this.jKT != null && this.jKT.getText() != null) {
            int selectionEnd = this.jKT.getSelectionEnd();
            SpannableStringBuilder c = this.jKS.c(this.jKT.getText());
            if (c != null) {
                this.jKS.yx(true);
                this.jKT.setText(c);
                if (z && this.jKS.dST() >= 0) {
                    this.jKT.requestFocus();
                    this.jKT.setSelection(this.jKS.dST());
                } else {
                    this.jKT.setSelection(selectionEnd);
                }
                this.jKS.yw(this.jKS.dST() >= 0);
            }
        }
    }

    public void cLJ() {
        if (bh.checkUpIsLogin(getContext())) {
            this.jKQ.bzY();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(int i) {
        this.jKU = i;
        this.jKP.setVisibility(0);
        if (i == 1) {
            this.jKP.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.jKP, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.jKP.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.jKP, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.jKP.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.jKP, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.jKP.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.jKP, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                VA();
            } else if (!this.mHasMore) {
                VA();
            } else {
                Vz();
            }
            if (!StringUtils.isNull(aVar.eBa)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), au.cutChineseAndEnglishWithSuffix(aVar.eBa, 14, StringHelper.STRING_MORE)));
            }
            this.jKK.setData(aVar.jKb);
            this.jmd.addHeaderView(this.jKK);
            this.jKL.setData(aVar.mDataList);
            if (this.mTopicDetailData.jKb.jKg != null) {
                if (this.mTopicDetailData.jKb.jKg.jLB.jLH) {
                    Cp(1);
                } else if (this.mTopicDetailData.jKb.jKg.jLC.jLH) {
                    Cp(2);
                } else {
                    Cp(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.jKP.setVisibility(8);
            }
            this.jKO.setPadding(dimens, 0, 0, 0);
            cLK();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            VA();
        } else {
            Vz();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).jKl = this.mTopicDetailData.cLE();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jmd.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPp() {
        this.jmd.setNextPage(null);
    }

    public void Vz() {
        this.mHasMore = true;
        this.jmd.setNextPage(this.giV);
        this.giV.startLoadData();
    }

    public void VA() {
        this.jmd.setNextPage(this.giV);
        this.giV.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iKB) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jKJ && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bsj();
            TiebaStatic.log(new ar("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bsj() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eBa;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.jKa) ? null : Uri.parse(this.mTopicDetailData.jKa);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.ffU = true;
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
            cLK();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.jKN, R.color.CAM_X0207);
            ap.setViewTextColor(this.jKO, R.color.CAM_X0109);
            this.jKO.setBackgroundDrawable(ap.aP(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            Cp(this.jKU);
            SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jKJ != null) {
                SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.giU != null) {
                this.giU.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.grV != null) {
                this.grV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.jKQ != null && this.jKQ.byN() != null) {
                this.jKQ.byN().onChangeSkinType(this.mSkinType);
            }
            if (this.giV != null) {
                this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
                this.giV.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.giV.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.giV.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.jKK != null) {
                this.jKK.onChangeSkinType();
            }
            if (this.jKL != null) {
                this.jKL.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jmd, R.color.CAM_X0205);
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void pb(boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.jKI != null) {
                            TopicDetailView.this.jKI.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jmd.setVisibility(8);
            SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jmd.setVisibility(0);
        SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cmm() {
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
        this.jmd.setOnSrollToBottomListener(null);
        if (this.giU != null) {
            this.giU.b(this.ghn);
        }
        if (this.jKQ != null) {
            this.jKQ.onDestory();
        }
        if (this.jKW != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jKW);
        }
        hideLoadingView();
        VB();
    }

    public a getEditor() {
        return this.jKQ;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.jKR != null) {
            ViewGroup.LayoutParams layoutParams = this.jKR.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.jKQ.byN().isVisible()) {
                    layoutParams2.addRule(2, this.jKQ.byN().getId());
                } else {
                    layoutParams2.addRule(2, this.jKM.getId());
                }
                this.jKR.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aF(bx bxVar) {
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
            cVar2.jKj = cVar.jKj;
            cVar2.evQ = bxVar;
            cVar2.source = 2;
            cVar2.jKk = this.jKU;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.jKl = this.mTopicDetailData.cLE();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.jKL.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLK() {
        if (this.mTopicDetailData != null && this.jKK != null) {
            if (this.jKX > this.jKY) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cLL()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cLL() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.jKK.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.jKK.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
