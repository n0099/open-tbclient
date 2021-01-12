package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.a.c> {
    private boolean akY;
    private TextView eGI;
    private TbPageContext eSJ;
    private ConstrainImageGroup irt;
    private com.baidu.tieba.homepage.topic.topicdetail.a.c khl;
    private ClickableHeaderImageView khm;
    private ImageView khn;
    private TextView kho;
    private AgreeView khp;
    private TextView khq;
    private ImageView khr;
    private TbRichTextView khs;
    private RelativeLayout kht;
    private View khu;
    private TbImageView khv;
    private TextView khw;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akY = true;
        this.mSkinType = 3;
        this.eSJ = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.khm = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.khn = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eGI = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.kho = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.khs = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.khs.setClickable(true);
        this.khs.setTextEllipsize(TextUtils.TruncateAt.END);
        this.khs.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.khs.setLayoutStrategy(aVar);
        this.kht = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.irt = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.irt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.r(1.0d);
        this.irt.setImageProcessor(aVar2);
        this.khp = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.khp.btp();
        this.khq = (TextView) view.findViewById(R.id.topic_comment_number);
        this.khr = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.khu = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.khv = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.khv.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.khv.setConrers(5);
        this.khv.setDrawCorner(true);
        this.khw = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eGI.setOnClickListener(this);
        this.khq.setOnClickListener(this);
        this.khr.setOnClickListener(this);
        this.khs.setOnClickListener(this);
        this.khu.setOnClickListener(this);
        this.khw.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.khl != null) {
            this.mSkinType = i;
            this.khm.setIsNight(this.mSkinType == 1);
            if (this.khl.kgw) {
                if (this.khl.kgv == 1) {
                    ao.setImageResource(this.khn, R.drawable.label_topic_agree_red);
                    this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.khl.kgv == 2) {
                    ao.setImageResource(this.khn, R.drawable.label_topic_disagree_blue);
                    this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ao.setImageResource(this.khn, R.drawable.label_topic_eat_black);
                    this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ao.setViewTextColor(this.eGI, R.color.CAM_X0105);
            ao.setViewTextColor(this.kho, R.color.CAM_X0109);
            ao.setViewTextColor(this.khq, R.color.CAM_X0107);
            if (this.khr != null) {
                SvgManager.bsx().a(this.khr, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.khp.onChangeSkinType(i);
            this.khs.setTextColor(ao.getColor(R.color.CAM_X0105));
            ao.d(this.khu, l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ao.setViewTextColor(this.khw, R.color.CAM_X0109);
            this.irt.onChangeSkinType();
            ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0205);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        String name_show;
        String formatTime;
        int bno;
        AgreeData bpr;
        if (cVar != null && cVar.eHK != null) {
            this.khl = cVar;
            onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
            bz bzVar = this.khl.eHK;
            PostData bpd = bzVar.bpd();
            if (bpd != null) {
                this.khm.setPlaceHolder(1);
                if (this.khl.source == 1) {
                    this.khm.setData(bzVar, false, true);
                } else {
                    this.khm.setData(bzVar, false, false);
                }
                this.khm.setIsRound(true);
                this.khm.setBorderWidth(2);
                this.khm.setDrawBorder(true);
                this.khm.setPageId(this.eSJ.getUniqueId());
                if (this.khl.kgw) {
                    this.khn.setVisibility(0);
                    if (this.khl.kgv == 1) {
                        this.khn.setImageResource(R.drawable.label_topic_agree_red);
                        this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.khl.kgv == 2) {
                        this.khn.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.khn.setImageResource(R.drawable.label_topic_eat_black);
                        this.khm.setBorderColor(this.eSJ.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.khn.setVisibility(8);
                }
                if (this.khl.source == 1) {
                    name_show = bpd.bnx().getName_show();
                    formatTime = at.getFormatTime(bpd.getTime());
                    bno = bpd.dLq();
                } else {
                    name_show = bzVar.bnx().getName_show();
                    formatTime = at.getFormatTime(bzVar.getCreateTime());
                    bno = bzVar.bno();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eGI.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bzVar.bnB())) {
                    this.kho.setText(formatTime);
                } else {
                    this.kho.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bzVar.bnB(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bsx().a(this.khr, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bno);
                if (bno > 0) {
                    this.khq.setVisibility(0);
                    this.khq.setText(numFormatOverWan);
                } else {
                    this.khq.setText(this.eSJ.getString(R.string.action_comment_default));
                    this.khq.setVisibility(0);
                }
                if (this.khl.source == 1) {
                    bpr = bpd.bpr();
                    bpr.objType = 1;
                } else {
                    bpr = bzVar.bpr();
                    bpr.objType = 3;
                }
                bpr.threadId = bzVar.getTid();
                this.khp.setData(bpr);
                this.khp.setTopicId(String.valueOf(this.khl.topicId));
                a(bpd, bzVar);
                a(cVar, bzVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bz bzVar) {
        if (this.khl.source == 1) {
            this.khs.setVisibility(0);
            this.khs.setText(postData.dLo());
            return;
        }
        List<PbContent> bnn = bzVar.bnn();
        if (x.getCount(bnn) > 0) {
            this.khs.setVisibility(0);
            this.khs.setText(TbRichTextView.a(getContext(), bnn, false));
            return;
        }
        SpannableString bou = bzVar.bou();
        if (bou != null && !StringUtils.isNull(bou.toString())) {
            this.khs.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bou);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.khs.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.khs.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar, bz bzVar) {
        if (this.khl.source == 1) {
            this.khu.setVisibility(0);
            this.kht.setVisibility(8);
            String title = bzVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.khu.setVisibility(8);
                return;
            }
            this.khu.setVisibility(0);
            this.khw.setText(title);
            String str = null;
            if (x.getCount(bzVar.bnG()) != 0 && !x.isEmpty(cVar.eHK.bnG())) {
                Iterator<MediaData> it = cVar.eHK.bnG().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                ao.setImageResource(this.khv, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.khv.setPlaceHolder(1);
            this.khv.startLoad(str, 10, false);
            return;
        }
        this.khu.setVisibility(8);
        this.kht.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        final bz bzVar = cVar.eHK;
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.kht.setVisibility(0);
                this.irt.setFromCDN(this.akY);
                this.irt.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bzVar);
                        } else {
                            d.this.byS();
                        }
                    }
                });
                this.irt.setImageMediaList(linkedList);
                return;
            }
            this.kht.setVisibility(8);
            return;
        }
        this.kht.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.irt != null) {
            this.irt.setPageUniqueId(bdUniqueId);
        }
    }

    public void byS() {
        if (this.khl != null && this.khl.eHK != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eSJ.getPageActivity()).createFromThreadCfg(this.khl.eHK, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.khl.eHK.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.khl.eHK.bnB());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Ic(this.khl.eHK.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cQq() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eSJ.getPageActivity()).createNormalCfg(String.valueOf(this.khl.eHK.getTid()), String.format("%1$s", this.khl.eHK.bpd().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bz bzVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.akY ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bzVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(arrayList).mN(i).zs(bzVar.bnB()).zt(String.valueOf(bzVar.getFid())).zu(bzVar.getTid()).je(this.akY).zv(arrayList.size() > 0 ? arrayList.get(0) : "").jf(true).d(concurrentHashMap).jg(true).s(bzVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eQ = aVar.eQ(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eQ.getIntent().putExtra("from", "index");
        } else {
            eQ.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eQ));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bzVar.getId();
        historyMessage.threadName = bzVar.getTitle();
        historyMessage.forumName = bzVar.bnB();
        historyMessage.postID = bzVar.bnN();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.khl != null && this.khl.eHK != null) {
            if (view == this.khs) {
                if (this.khl.source == 1) {
                    cQq();
                } else {
                    byS();
                }
                Ls("1");
            }
            if (view == this.khq || view == this.khr) {
                if (this.khl.source == 1) {
                    cQq();
                } else {
                    byS();
                }
                Ls("3");
            } else if (view == this.eGI) {
                cQr();
            } else {
                byS();
                Ls("2");
            }
        }
    }

    private void cQr() {
        MetaData bnx;
        if (this.khl != null && this.khl.eHK != null) {
            bz bzVar = this.khl.eHK;
            if (this.khl.source == 1 && bzVar.bpd() != null) {
                bnx = bzVar.bpd().bnx();
            } else {
                bnx = bzVar.bnx();
            }
            if (bnx != null && !StringUtils.isNull(bnx.getName_show()) && !StringUtils.isNull(bnx.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bnx.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnx.isBigV());
                createNormalConfig.setSourceTid(bzVar.getTid());
                createNormalConfig.setSourceNid(bzVar.blV());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Ls(String str) {
        TiebaStatic.log(new aq("c13356").dW("obj_locate", str).dW("tid", this.khl.eHK.getTid()).w("topic_id", this.khl.topicId).dW("obj_type", String.valueOf(this.khl.source)));
    }
}
