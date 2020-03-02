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
    private boolean NJ;
    private TbPageContext cVh;
    private TextView cbK;
    private ConstrainImageGroup fJP;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hgZ;
    private ClickableHeaderImageView hha;
    private ImageView hhb;
    private TextView hhc;
    private AgreeView hhd;
    private TextView hhe;
    private ImageView hhf;
    private TbRichTextView hhg;
    private RelativeLayout hhh;
    private View hhi;
    private TbImageView hhj;
    private TextView hhk;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.NJ = true;
        this.mSkinType = 3;
        this.cVh = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hha = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hhb = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cbK = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hhc = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hhg = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hhg.setClickable(true);
        this.hhg.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hhg.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hhg.setLayoutStrategy(aVar);
        this.hhh = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.fJP = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.fJP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.fJP.setImageProcessor(aVar2);
        this.hhd = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hhd.aHp();
        this.hhe = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hhf = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hhi = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hhj = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hhj.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hhj.setConrers(5);
        this.hhj.setDrawCorner(true);
        this.hhk = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cbK.setOnClickListener(this);
        this.hhe.setOnClickListener(this);
        this.hhf.setOnClickListener(this);
        this.hhg.setOnClickListener(this);
        this.hhi.setOnClickListener(this);
        this.hhk.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJP != null) {
            this.fJP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJP != null) {
            this.fJP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJP != null) {
            this.fJP.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hgZ != null) {
            this.mSkinType = i;
            this.hha.setIsNight(this.mSkinType == 1);
            if (this.hgZ.hgk) {
                if (this.hgZ.hgj == 1) {
                    am.setImageResource(this.hhb, R.drawable.label_topic_agree_red);
                    this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hgZ.hgj == 2) {
                    am.setImageResource(this.hhb, R.drawable.label_topic_disagree_blue);
                    this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hhb, R.drawable.label_topic_eat_black);
                    this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.cbK, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hhc, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hhe, (int) R.color.cp_cont_j);
            if (this.hhf != null) {
                SvgManager.aGC().a(this.hhf, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hhd.onChangeSkinType(i);
            this.hhg.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hhi, l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hhk, (int) R.color.cp_cont_d);
            this.fJP.onChangeSkinType();
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
        int aCf;
        AgreeData aEa;
        if (cVar != null && cVar.cRf != null) {
            this.hgZ = cVar;
            onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hgZ.cRf;
            PostData aDM = bjVar.aDM();
            if (aDM != null) {
                this.hha.setPlaceHolder(1);
                if (this.hgZ.source == 1) {
                    this.hha.setData(bjVar, false, true);
                } else {
                    this.hha.setData(bjVar, false, false);
                }
                this.hha.setIsRound(true);
                this.hha.setBorderWidth(2);
                this.hha.setDrawBorder(true);
                this.hha.setPageId(this.cVh.getUniqueId());
                if (this.hgZ.hgk) {
                    this.hhb.setVisibility(0);
                    if (this.hgZ.hgj == 1) {
                        this.hhb.setImageResource(R.drawable.label_topic_agree_red);
                        this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hgZ.hgj == 2) {
                        this.hhb.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hhb.setImageResource(R.drawable.label_topic_eat_black);
                        this.hha.setBorderColor(this.cVh.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hhb.setVisibility(8);
                }
                if (this.hgZ.source == 1) {
                    name_show = aDM.aCo().getName_show();
                    formatTime = aq.getFormatTime(aDM.getTime());
                    aCf = aDM.cLe();
                } else {
                    name_show = bjVar.aCo().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    aCf = bjVar.aCf();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cbK.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aCt())) {
                    this.hhc.setText(formatTime);
                } else {
                    this.hhc.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aCt(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aGC().a(this.hhf, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aCf);
                if (aCf > 0) {
                    this.hhe.setVisibility(0);
                    this.hhe.setText(numFormatOverWan);
                } else {
                    this.hhe.setText(this.cVh.getString(R.string.action_comment_default));
                    this.hhe.setVisibility(0);
                }
                if (this.hgZ.source == 1) {
                    aEa = aDM.aEa();
                    aEa.objType = 1;
                } else {
                    aEa = bjVar.aEa();
                    aEa.objType = 3;
                }
                aEa.threadId = bjVar.getTid();
                this.hhd.setData(aEa);
                this.hhd.setTopicId(String.valueOf(this.hgZ.topicId));
                a(aDM, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hgZ.source == 1) {
            this.hhg.setVisibility(0);
            this.hhg.setText(postData.cLc());
            return;
        }
        List<PbContent> aCe = bjVar.aCe();
        if (v.getCount(aCe) > 0) {
            this.hhg.setVisibility(0);
            this.hhg.setText(TbRichTextView.a(getContext(), aCe, false));
            return;
        }
        SpannableString aDg = bjVar.aDg();
        if (aDg != null && !StringUtils.isNull(aDg.toString())) {
            this.hhg.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aDg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hhg.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hhg.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hgZ.source == 1) {
            this.hhi.setVisibility(0);
            this.hhh.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hhi.setVisibility(8);
                return;
            }
            this.hhi.setVisibility(0);
            this.hhk.setText(title);
            String str = null;
            if (v.getCount(bjVar.aCy()) != 0 && !v.isEmpty(cVar.cRf.aCy())) {
                Iterator<MediaData> it = cVar.cRf.aCy().iterator();
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
                am.setImageResource(this.hhj, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hhj.setPlaceHolder(1);
            this.hhj.startLoad(str, 10, false);
            return;
        }
        this.hhi.setVisibility(8);
        this.hhh.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.cRf;
        ArrayList<MediaData> aCy = bjVar.aCy();
        if (i.azO().isShowImages() && v.getCount(aCy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCy.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hhh.setVisibility(0);
                this.fJP.setFromCDN(this.NJ);
                this.fJP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aMy();
                        }
                    }
                });
                this.fJP.setImageMediaList(linkedList);
                return;
            }
            this.hhh.setVisibility(8);
            return;
        }
        this.hhh.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fJP != null) {
            this.fJP.setPageUniqueId(bdUniqueId);
        }
    }

    public void aMy() {
        if (this.hgZ != null && this.hgZ.cRf != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVh.getPageActivity()).createFromThreadCfg(this.hgZ.cRf, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hgZ.cRf.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hgZ.cRf.aCt());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.zS(this.hgZ.cRf.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bPA() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cVh.getPageActivity()).createNormalCfg(String.valueOf(this.hgZ.cRf.getTid()), String.format("%1$s", this.hgZ.cRf.aDM().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.NJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCt(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aCt();
        historyMessage.postID = bjVar.aCE();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hgZ != null && this.hgZ.cRf != null) {
            if (view == this.hhg) {
                if (this.hgZ.source == 1) {
                    bPA();
                } else {
                    aMy();
                }
                Cl("1");
            }
            if (view == this.hhe || view == this.hhf) {
                if (this.hgZ.source == 1) {
                    bPA();
                } else {
                    aMy();
                }
                Cl("3");
            } else if (view == this.cbK) {
                bPB();
            } else {
                aMy();
                Cl("2");
            }
        }
    }

    private void bPB() {
        MetaData aCo;
        if (this.hgZ != null && this.hgZ.cRf != null) {
            bj bjVar = this.hgZ.cRf;
            if (this.hgZ.source == 1 && bjVar.aDM() != null) {
                aCo = bjVar.aDM().aCo();
            } else {
                aCo = bjVar.aCo();
            }
            if (aCo != null && !StringUtils.isNull(aCo.getName_show()) && !StringUtils.isNull(aCo.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aCo.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCo.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Cl(String str) {
        TiebaStatic.log(new an("c13356").cy("obj_locate", str).cy("tid", this.hgZ.cRf.getTid()).s("topic_id", this.hgZ.topicId).cy("obj_type", String.valueOf(this.hgZ.source)));
    }
}
