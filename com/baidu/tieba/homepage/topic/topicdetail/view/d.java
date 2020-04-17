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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean agt;
    private TextView cAX;
    private TbPageContext duG;
    private ConstrainImageGroup gpr;
    private TextView hSA;
    private ImageView hSB;
    private TbRichTextView hSC;
    private RelativeLayout hSD;
    private View hSE;
    private TbImageView hSF;
    private TextView hSG;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hSv;
    private ClickableHeaderImageView hSw;
    private ImageView hSx;
    private TextView hSy;
    private AgreeView hSz;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.agt = true;
        this.mSkinType = 3;
        this.duG = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hSw = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hSx = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cAX = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hSy = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hSC = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hSC.setClickable(true);
        this.hSC.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hSC.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hSC.setLayoutStrategy(aVar);
        this.hSD = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gpr = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gpr.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.n(1.0d);
        this.gpr.setImageProcessor(aVar2);
        this.hSz = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hSz.aPM();
        this.hSA = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hSB = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hSE = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hSF = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hSF.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hSF.setConrers(5);
        this.hSF.setDrawCorner(true);
        this.hSG = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cAX.setOnClickListener(this);
        this.hSA.setOnClickListener(this);
        this.hSB.setOnClickListener(this);
        this.hSC.setOnClickListener(this);
        this.hSE.setOnClickListener(this);
        this.hSG.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpr != null) {
            this.gpr.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpr != null) {
            this.gpr.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.gpr != null) {
            this.gpr.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hSv != null) {
            this.mSkinType = i;
            this.hSw.setIsNight(this.mSkinType == 1);
            if (this.hSv.hRG) {
                if (this.hSv.hRF == 1) {
                    am.setImageResource(this.hSx, R.drawable.label_topic_agree_red);
                    this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hSv.hRF == 2) {
                    am.setImageResource(this.hSx, R.drawable.label_topic_disagree_blue);
                    this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hSx, R.drawable.label_topic_eat_black);
                    this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.cAX, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hSy, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hSA, (int) R.color.cp_cont_j);
            if (this.hSB != null) {
                SvgManager.aOU().a(this.hSB, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hSz.onChangeSkinType(i);
            this.hSC.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hSE, l.getDimens(this.duG.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hSG, (int) R.color.cp_cont_d);
            this.gpr.onChangeSkinType();
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int aKv;
        AgreeData aMs;
        if (cVar != null && cVar.dqA != null) {
            this.hSv = cVar;
            onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hSv.dqA;
            PostData aMe = bjVar.aMe();
            if (aMe != null) {
                this.hSw.setPlaceHolder(1);
                if (this.hSv.source == 1) {
                    this.hSw.setData(bjVar, false, true);
                } else {
                    this.hSw.setData(bjVar, false, false);
                }
                this.hSw.setIsRound(true);
                this.hSw.setBorderWidth(2);
                this.hSw.setDrawBorder(true);
                this.hSw.setPageId(this.duG.getUniqueId());
                if (this.hSv.hRG) {
                    this.hSx.setVisibility(0);
                    if (this.hSv.hRF == 1) {
                        this.hSx.setImageResource(R.drawable.label_topic_agree_red);
                        this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hSv.hRF == 2) {
                        this.hSx.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hSx.setImageResource(R.drawable.label_topic_eat_black);
                        this.hSw.setBorderColor(this.duG.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hSx.setVisibility(8);
                }
                if (this.hSv.source == 1) {
                    name_show = aMe.aKE().getName_show();
                    formatTime = aq.getFormatTime(aMe.getTime());
                    aKv = aMe.cWv();
                } else {
                    name_show = bjVar.aKE().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    aKv = bjVar.aKv();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cAX.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aKJ())) {
                    this.hSy.setText(formatTime);
                } else {
                    this.hSy.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aKJ(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aOU().a(this.hSB, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aKv);
                if (aKv > 0) {
                    this.hSA.setVisibility(0);
                    this.hSA.setText(numFormatOverWan);
                } else {
                    this.hSA.setText(this.duG.getString(R.string.action_comment_default));
                    this.hSA.setVisibility(0);
                }
                if (this.hSv.source == 1) {
                    aMs = aMe.aMs();
                    aMs.objType = 1;
                } else {
                    aMs = bjVar.aMs();
                    aMs.objType = 3;
                }
                aMs.threadId = bjVar.getTid();
                this.hSz.setData(aMs);
                this.hSz.setTopicId(String.valueOf(this.hSv.topicId));
                a(aMe, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hSv.source == 1) {
            this.hSC.setVisibility(0);
            this.hSC.setText(postData.cWt());
            return;
        }
        List<PbContent> aKu = bjVar.aKu();
        if (v.getCount(aKu) > 0) {
            this.hSC.setVisibility(0);
            this.hSC.setText(TbRichTextView.a(getContext(), aKu, false));
            return;
        }
        SpannableString aLw = bjVar.aLw();
        if (aLw != null && !StringUtils.isNull(aLw.toString())) {
            this.hSC.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aLw);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hSC.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hSC.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hSv.source == 1) {
            this.hSE.setVisibility(0);
            this.hSD.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hSE.setVisibility(8);
                return;
            }
            this.hSE.setVisibility(0);
            this.hSG.setText(title);
            String str = null;
            if (v.getCount(bjVar.aKO()) != 0 && !v.isEmpty(cVar.dqA.aKO())) {
                Iterator<MediaData> it = cVar.dqA.aKO().iterator();
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
                am.setImageResource(this.hSF, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hSF.setPlaceHolder(1);
            this.hSF.startLoad(str, 10, false);
            return;
        }
        this.hSE.setVisibility(8);
        this.hSD.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.dqA;
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (i.aIe().isShowImages() && v.getCount(aKO) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hSD.setVisibility(0);
                this.gpr.setFromCDN(this.agt);
                this.gpr.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aVa();
                        }
                    }
                });
                this.gpr.setImageMediaList(linkedList);
                return;
            }
            this.hSD.setVisibility(8);
            return;
        }
        this.hSD.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gpr != null) {
            this.gpr.setPageUniqueId(bdUniqueId);
        }
    }

    public void aVa() {
        if (this.hSv != null && this.hSv.dqA != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.duG.getPageActivity()).createFromThreadCfg(this.hSv.dqA, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hSv.dqA.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hSv.dqA.aKJ());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.BB(this.hSv.dqA.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cat() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.duG.getPageActivity()).createNormalCfg(String.valueOf(this.hSv.dqA.getTid()), String.format("%1$s", this.hSv.dqA.aMe().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.agt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aKJ(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.agt, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bjVar.getId();
        historyMessage.threadName = bjVar.getTitle();
        historyMessage.forumName = bjVar.aKJ();
        historyMessage.postID = bjVar.aKU();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSv != null && this.hSv.dqA != null) {
            if (view == this.hSC) {
                if (this.hSv.source == 1) {
                    cat();
                } else {
                    aVa();
                }
                DU("1");
            }
            if (view == this.hSA || view == this.hSB) {
                if (this.hSv.source == 1) {
                    cat();
                } else {
                    aVa();
                }
                DU("3");
            } else if (view == this.cAX) {
                cau();
            } else {
                aVa();
                DU("2");
            }
        }
    }

    private void cau() {
        MetaData aKE;
        if (this.hSv != null && this.hSv.dqA != null) {
            bj bjVar = this.hSv.dqA;
            if (this.hSv.source == 1 && bjVar.aMe() != null) {
                aKE = bjVar.aMe().aKE();
            } else {
                aKE = bjVar.aKE();
            }
            if (aKE != null && !StringUtils.isNull(aKE.getName_show()) && !StringUtils.isNull(aKE.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aKE.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKE.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void DU(String str) {
        TiebaStatic.log(new an("c13356").cI("obj_locate", str).cI("tid", this.hSv.dqA.getTid()).t("topic_id", this.hSv.topicId).cI("obj_type", String.valueOf(this.hSv.source)));
    }
}
