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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean aib;
    private TextView dKI;
    private TbPageContext dVN;
    private ConstrainImageGroup gWS;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c iFh;
    private ClickableHeaderImageView iFi;
    private ImageView iFj;
    private TextView iFk;
    private AgreeView iFl;
    private TextView iFm;
    private ImageView iFn;
    private TbRichTextView iFo;
    private RelativeLayout iFp;
    private View iFq;
    private TbImageView iFr;
    private TextView iFs;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aib = true;
        this.mSkinType = 3;
        this.dVN = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iFi = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.iFj = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dKI = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.iFk = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.iFo = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.iFo.setClickable(true);
        this.iFo.setTextEllipsize(TextUtils.TruncateAt.END);
        this.iFo.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iFo.setLayoutStrategy(aVar);
        this.iFp = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gWS = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gWS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.o(1.0d);
        this.gWS.setImageProcessor(aVar2);
        this.iFl = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.iFl.bbI();
        this.iFm = (TextView) view.findViewById(R.id.topic_comment_number);
        this.iFn = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.iFq = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.iFr = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.iFr.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.iFr.setConrers(5);
        this.iFr.setDrawCorner(true);
        this.iFs = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dKI.setOnClickListener(this);
        this.iFm.setOnClickListener(this);
        this.iFn.setOnClickListener(this);
        this.iFo.setOnClickListener(this);
        this.iFq.setOnClickListener(this);
        this.iFs.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.iFh != null) {
            this.mSkinType = i;
            this.iFi.setIsNight(this.mSkinType == 1);
            if (this.iFh.iEs) {
                if (this.iFh.iEr == 1) {
                    ao.setImageResource(this.iFj, R.drawable.label_topic_agree_red);
                    this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.iFh.iEr == 2) {
                    ao.setImageResource(this.iFj, R.drawable.label_topic_disagree_blue);
                    this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ao.setImageResource(this.iFj, R.drawable.label_topic_eat_black);
                    this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ao.setViewTextColor(this.dKI, R.color.cp_cont_b);
            ao.setViewTextColor(this.iFk, R.color.cp_cont_d);
            ao.setViewTextColor(this.iFm, R.color.cp_cont_j);
            if (this.iFn != null) {
                SvgManager.baR().a(this.iFn, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.iFl.onChangeSkinType(i);
            this.iFo.setTextColor(ao.getColor(R.color.cp_cont_b));
            ao.c(this.iFq, l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ao.setViewTextColor(this.iFs, R.color.cp_cont_d);
            this.gWS.onChangeSkinType();
            ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int aWc;
        AgreeData aYc;
        if (cVar != null && cVar.dLK != null) {
            this.iFh = cVar;
            onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
            bv bvVar = this.iFh.dLK;
            PostData aXO = bvVar.aXO();
            if (aXO != null) {
                this.iFi.setPlaceHolder(1);
                if (this.iFh.source == 1) {
                    this.iFi.setData(bvVar, false, true);
                } else {
                    this.iFi.setData(bvVar, false, false);
                }
                this.iFi.setIsRound(true);
                this.iFi.setBorderWidth(2);
                this.iFi.setDrawBorder(true);
                this.iFi.setPageId(this.dVN.getUniqueId());
                if (this.iFh.iEs) {
                    this.iFj.setVisibility(0);
                    if (this.iFh.iEr == 1) {
                        this.iFj.setImageResource(R.drawable.label_topic_agree_red);
                        this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.iFh.iEr == 2) {
                        this.iFj.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.iFj.setImageResource(R.drawable.label_topic_eat_black);
                        this.iFi.setBorderColor(this.dVN.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.iFj.setVisibility(8);
                }
                if (this.iFh.source == 1) {
                    name_show = aXO.aWl().getName_show();
                    formatTime = as.getFormatTime(aXO.getTime());
                    aWc = aXO.dll();
                } else {
                    name_show = bvVar.aWl().getName_show();
                    formatTime = as.getFormatTime(bvVar.getCreateTime());
                    aWc = bvVar.aWc();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dKI.setText(as.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bvVar.aWp())) {
                    this.iFk.setText(formatTime);
                } else {
                    this.iFk.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), as.cutChineseAndEnglishWithSuffix(bvVar.aWp(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.baR().a(this.iFn, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = as.numFormatOverWan(aWc);
                if (aWc > 0) {
                    this.iFm.setVisibility(0);
                    this.iFm.setText(numFormatOverWan);
                } else {
                    this.iFm.setText(this.dVN.getString(R.string.action_comment_default));
                    this.iFm.setVisibility(0);
                }
                if (this.iFh.source == 1) {
                    aYc = aXO.aYc();
                    aYc.objType = 1;
                } else {
                    aYc = bvVar.aYc();
                    aYc.objType = 3;
                }
                aYc.threadId = bvVar.getTid();
                this.iFl.setData(aYc);
                this.iFl.setTopicId(String.valueOf(this.iFh.topicId));
                a(aXO, bvVar);
                a(cVar, bvVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bv bvVar) {
        if (this.iFh.source == 1) {
            this.iFo.setVisibility(0);
            this.iFo.setText(postData.dlj());
            return;
        }
        List<PbContent> aWb = bvVar.aWb();
        if (x.getCount(aWb) > 0) {
            this.iFo.setVisibility(0);
            this.iFo.setText(TbRichTextView.a(getContext(), aWb, false));
            return;
        }
        SpannableString aXg = bvVar.aXg();
        if (aXg != null && !StringUtils.isNull(aXg.toString())) {
            this.iFo.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aXg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.iFo.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.iFo.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bv bvVar) {
        if (this.iFh.source == 1) {
            this.iFq.setVisibility(0);
            this.iFp.setVisibility(8);
            String title = bvVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.iFq.setVisibility(8);
                return;
            }
            this.iFq.setVisibility(0);
            this.iFs.setText(title);
            String str = null;
            if (x.getCount(bvVar.aWu()) != 0 && !x.isEmpty(cVar.dLK.aWu())) {
                Iterator<MediaData> it = cVar.dLK.aWu().iterator();
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
                ao.setImageResource(this.iFr, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.iFr.setPlaceHolder(1);
            this.iFr.startLoad(str, 10, false);
            return;
        }
        this.iFq.setVisibility(8);
        this.iFp.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bv bvVar = cVar.dLK;
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.iFp.setVisibility(0);
                this.gWS.setFromCDN(this.aib);
                this.gWS.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bvVar);
                        } else {
                            d.this.bgS();
                        }
                    }
                });
                this.gWS.setImageMediaList(linkedList);
                return;
            }
            this.iFp.setVisibility(8);
            return;
        }
        this.iFp.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gWS != null) {
            this.gWS.setPageUniqueId(bdUniqueId);
        }
    }

    public void bgS() {
        if (this.iFh != null && this.iFh.dLK != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dVN.getPageActivity()).createFromThreadCfg(this.iFh.dLK, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.iFh.dLK.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.iFh.dLK.aWp());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.Ez(this.iFh.dLK.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void con() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.dVN.getPageActivity()).createNormalCfg(String.valueOf(this.iFh.dLK.getTid()), String.format("%1$s", this.iFh.dLK.aXO().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bv bvVar) {
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
                    imageUrlData.urlType = this.aib ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bvVar.getTid(), -1L);
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
        aVar.s(arrayList).kG(i).wE(bvVar.aWp()).wF(String.valueOf(bvVar.getFid())).wG(bvVar.getTid()).hl(this.aib).wH(arrayList.size() > 0 ? arrayList.get(0) : "").hm(true).a(concurrentHashMap).hn(true).r(bvVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dI = aVar.dI(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dI.getIntent().putExtra("from", "index");
        } else {
            dI.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dI));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bvVar.getId();
        historyMessage.threadName = bvVar.getTitle();
        historyMessage.forumName = bvVar.aWp();
        historyMessage.postID = bvVar.aWC();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iFh != null && this.iFh.dLK != null) {
            if (view == this.iFo) {
                if (this.iFh.source == 1) {
                    con();
                } else {
                    bgS();
                }
                GU("1");
            }
            if (view == this.iFm || view == this.iFn) {
                if (this.iFh.source == 1) {
                    con();
                } else {
                    bgS();
                }
                GU("3");
            } else if (view == this.dKI) {
                coo();
            } else {
                bgS();
                GU("2");
            }
        }
    }

    private void coo() {
        MetaData aWl;
        if (this.iFh != null && this.iFh.dLK != null) {
            bv bvVar = this.iFh.dLK;
            if (this.iFh.source == 1 && bvVar.aXO() != null) {
                aWl = bvVar.aXO().aWl();
            } else {
                aWl = bvVar.aWl();
            }
            if (aWl != null && !StringUtils.isNull(aWl.getName_show()) && !StringUtils.isNull(aWl.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aWl.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aWl.isBigV());
                createNormalConfig.setSourceTid(bvVar.getTid());
                createNormalConfig.setSourceNid(bvVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void GU(String str) {
        TiebaStatic.log(new ap("c13356").dn("obj_locate", str).dn("tid", this.iFh.dLK.getTid()).t("topic_id", this.iFh.topicId).dn("obj_type", String.valueOf(this.iFh.source)));
    }
}
