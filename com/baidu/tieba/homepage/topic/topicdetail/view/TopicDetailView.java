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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
/* loaded from: classes16.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e UC;
    private com.baidu.tbadk.editortools.pb.b eBY;
    private g fBv;
    private NoNetworkView.a fqT;
    private NoNetworkView fsB;
    private PbListView fsC;
    private View hHY;
    private com.baidu.tieba.homepage.topic.topicdetail.a iEQ;
    private ImageView iER;
    private TopicDetailHeadView iES;
    private com.baidu.tieba.homepage.topic.topicdetail.a.b iET;
    private View iEU;
    private View iEV;
    private TextView iEW;
    private TextView iEX;
    private a iEY;
    private View iEZ;
    private com.baidu.tieba.write.c iFa;
    private EditText iFb;
    private int iFc;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a iFd;
    a.RunnableC0650a iFe;
    private int iFf;
    private int iFg;
    private NewWriteModel.d iFh;
    private BdTypeRecyclerView iiC;
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
        this.iEV = null;
        this.iEW = null;
        this.iEX = null;
        this.mHasMore = true;
        this.iFf = 0;
        this.iFg = 44;
        this.fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.iEQ != null) {
                    TopicDetailView.this.iEQ.loadData();
                }
            }
        };
        this.eBY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bji() {
                if (TopicDetailView.this.iFa.dub()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.iFa.dud());
                    TopicDetailView.this.pk(true);
                    return true;
                }
                return false;
            }
        };
        this.iFh = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.iEY != null && TopicDetailView.this.iEY.biJ() != null) {
                    TopicDetailView.this.iEY.biJ().hide();
                }
                if (z) {
                    TopicDetailView.this.iFa.Py(null);
                    TopicDetailView.this.iFa.aZ(null);
                    TopicDetailView.this.iFa.wi(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.iFe = TopicDetailView.this.iFd.B(j, j2);
                            com.baidu.adp.lib.f.e.lt().postDelayed(TopicDetailView.this.iFe, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.iFa.aZ(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.iFa.Py(postWriteCallBackData.getErrorString());
                    if (!x.isEmpty(TopicDetailView.this.iFa.dtZ())) {
                        TopicDetailView.this.pk(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.iEY != null) {
                    TopicDetailView.this.iEY.bjM();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.iiC, i);
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.iFf += i2;
                TopicDetailView.this.col();
            }
        };
        this.UC = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bxU();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).eF(((com.baidu.tieba.homepage.topic.topicdetail.b.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).iEs);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.iEQ = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.hHY == null) {
            this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hHY.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.hHY.findViewById(R.id.widget_navi_back_button);
        }
        this.iER = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.fsB = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.fsB.a(this.fqT);
        this.iEV = findViewById(R.id.pb_editor_tool_comment);
        this.iEW = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.iEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cok();
            }
        });
        this.iEX = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.iEU = findViewById(R.id.activity_topic_detail_editor);
        as(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.iEY.biJ(), layoutParams);
        this.iFa = new com.baidu.tieba.write.c();
        this.iEZ = findViewById(R.id.activity_topic_detail_editor_top);
        this.iiC = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.iiC.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iiC.setFadingEdgeLength(0);
        this.iiC.setOverScrollMode(2);
        this.iiC.setOnSrollToBottomListener(this.UC);
        this.iiC.addOnScrollListener(this.mScrollListener);
        ao.setBackgroundColor(this.iiC, R.color.cp_bg_line_d);
        this.iET = new com.baidu.tieba.homepage.topic.topicdetail.a.b(this.mPageContext, this.iiC);
        this.iES = new TopicDetailHeadView(getContext());
        this.iES.iEO.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void xL(int i) {
                TopicDetailView.this.xK(i);
            }
        });
        if (this.fBv == null) {
            this.fsC = new PbListView(this.mPageContext.getPageActivity());
            this.fsC.getView();
        }
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_e));
        this.fsC.setContainerBackgroundColorResId(ao.getColor(R.color.cp_bg_line_d));
        this.fsC.setLineColorResource(ao.getColor(R.color.cp_bg_line_c));
        this.fsC.setText(getResources().getString(R.string.list_has_no_more));
        this.fsC.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.iFd == null) {
            this.iFd = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.iFd.m(this.mPageContext.getUniqueId());
        }
    }

    private void as(Bundle bundle) {
        this.iEY = (a) new b().dT(getContext());
        if (this.iEY != null) {
            this.iEY.a(this.mPageContext);
            this.iEY.b(this.iFh);
            this.iEY.a(this.eBY);
            this.iEY.biJ().iJ(true);
            this.iEY.biJ().setBarBackgroundColorId(R.color.cp_bg_line_h);
            this.iEY.a((BaseActivity) getContext(), bundle);
            this.iEY.bjM();
            this.iEY.biJ().setId(R.id.topic_editor);
            this.iFb = this.iEY.coj().getInputView();
            this.iFb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.iFa != null) {
                        if (!TopicDetailView.this.iFa.duc()) {
                            TopicDetailView.this.pk(false);
                        }
                        TopicDetailView.this.iFa.wj(false);
                    }
                }
            });
        }
    }

    public void pk(boolean z) {
        if (this.iFb != null && this.iFb.getText() != null) {
            int selectionEnd = this.iFb.getSelectionEnd();
            SpannableStringBuilder d = this.iFa.d(this.iFb.getText());
            if (d != null) {
                this.iFa.wj(true);
                this.iFb.setText(d);
                if (z && this.iFa.dua() >= 0) {
                    this.iFb.requestFocus();
                    this.iFb.setSelection(this.iFa.dua());
                } else {
                    this.iFb.setSelection(selectionEnd);
                }
                this.iFa.wi(this.iFa.dua() >= 0);
            }
        }
    }

    public void cok() {
        if (bf.checkUpIsLogin(getContext())) {
            this.iEY.bjP();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ap("c13359").dn("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK(int i) {
        this.iFc = i;
        this.iEX.setVisibility(0);
        if (i == 1) {
            this.iEX.setText(R.string.topic_detail_pk_support);
            ao.setBackgroundResource(this.iEX, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.iEX.setText(R.string.topic_detail_pk_oppose);
            ao.setBackgroundResource(this.iEX, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.iEX.setText(R.string.topic_detail_pk_chigua);
            ao.setBackgroundResource(this.iEX, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.iEX.setTextColor(-2130706433);
        } else {
            ao.setViewTextColor(this.iEX, R.color.cp_cont_a);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                bxT();
            } else if (!this.mHasMore) {
                bxT();
            } else {
                bxS();
            }
            if (!StringUtils.isNull(aVar.dQI)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), as.cutChineseAndEnglishWithSuffix(aVar.dQI, 14, StringHelper.STRING_MORE)));
            }
            this.iES.setData(aVar.iEk);
            this.iiC.addHeaderView(this.iES);
            this.iET.setData(aVar.mDataList);
            if (this.mTopicDetailData.iEk.iEp != null) {
                if (this.mTopicDetailData.iEk.iEp.iFJ.iFP) {
                    xK(1);
                } else if (this.mTopicDetailData.iEk.iEp.iFK.iFP) {
                    xK(2);
                } else {
                    xK(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.iEX.setVisibility(8);
            }
            this.iEW.setPadding(dimens, 0, 0, 0);
            col();
        }
    }

    public void setNextData(int i, boolean z, List<q> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            bxT();
        } else {
            bxS();
        }
        if (i == 0 && list != null && !x.isEmpty(list)) {
            for (q qVar : list) {
                if (qVar instanceof com.baidu.tieba.homepage.topic.topicdetail.b.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.b.c) qVar).iEu = this.mTopicDetailData.cof();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.iiC.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxU() {
        this.iiC.setNextPage(null);
    }

    public void bxS() {
        this.mHasMore = true;
        this.iiC.setNextPage(this.fsC);
        this.fsC.startLoadData();
    }

    public void bxT() {
        this.iiC.setNextPage(this.fsC);
        this.fsC.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHY) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.iER && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bcy();
            TiebaStatic.log(new ap("c13364").dn("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bcy() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.dQI;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.iEj) ? null : Uri.parse(this.mTopicDetailData.iEj);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.etK = true;
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
            col();
            ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
            ao.setBackgroundResource(this.iEV, R.color.cp_bg_line_h);
            ao.setViewTextColor(this.iEW, R.color.cp_cont_d);
            this.iEW.setBackgroundDrawable(ao.aH(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ao.getColor(R.color.cp_bg_line_j)));
            xK(this.iFc);
            SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.iER != null) {
                SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.fsB != null) {
                this.fsB.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.fBv != null) {
                this.fBv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.iEY != null && this.iEY.biJ() != null) {
                this.iEY.biJ().onChangeSkinType(this.mSkinType);
            }
            if (this.fsC != null) {
                this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
                this.fsC.setTextColor(ao.getColor(R.color.cp_cont_e));
                this.fsC.setContainerBackgroundColorResId(ao.getColor(R.color.cp_bg_line_d));
                this.fsC.setLineColorResource(ao.getColor(R.color.cp_bg_line_c));
            }
            if (this.iES != null) {
                this.iES.onChangeSkinType();
            }
            if (this.iET != null) {
                this.iET.notifyDataSetChanged();
            }
            ao.setBackgroundColor(this.iiC, R.color.cp_bg_line_e);
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.iEQ != null) {
                            TopicDetailView.this.iEQ.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.iiC.setVisibility(8);
            SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.iiC.setVisibility(0);
        SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean bWj() {
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
        this.iiC.setOnSrollToBottomListener(null);
        if (this.fsB != null) {
            this.fsB.b(this.fqT);
        }
        if (this.iEY != null) {
            this.iEY.onDestory();
        }
        if (this.iFe != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iFe);
        }
        hideLoadingView();
        bwX();
    }

    public a getEditor() {
        return this.iEY;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.iEZ != null) {
            ViewGroup.LayoutParams layoutParams = this.iEZ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.iEY.biJ().isVisible()) {
                    layoutParams2.addRule(2, this.iEY.biJ().getId());
                } else {
                    layoutParams2.addRule(2, this.iEU.getId());
                }
                this.iEZ.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aB(bv bvVar) {
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
            cVar2.iEs = cVar.iEs;
            cVar2.dLK = bvVar;
            cVar2.source = 2;
            cVar2.iEt = this.iFc;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.iEu = this.mTopicDetailData.cof();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.iET.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void col() {
        if (this.mTopicDetailData != null && this.iES != null) {
            if (this.iFf > this.iFg) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com()));
                return;
            }
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap com() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.iES.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.iES.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}
