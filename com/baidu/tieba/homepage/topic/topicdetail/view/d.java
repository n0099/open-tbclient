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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean aik;
    private TextView dEL;
    private TbPageContext dPv;
    private ConstrainImageGroup gRn;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c izd;
    private ClickableHeaderImageView ize;
    private ImageView izf;
    private TextView izg;
    private AgreeView izh;
    private TextView izi;
    private ImageView izj;
    private TbRichTextView izk;
    private RelativeLayout izl;
    private View izm;
    private TbImageView izn;
    private TextView izo;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aik = true;
        this.mSkinType = 3;
        this.dPv = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ize = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.izf = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dEL = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.izg = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.izk = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.izk.setClickable(true);
        this.izk.setTextEllipsize(TextUtils.TruncateAt.END);
        this.izk.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.izk.setLayoutStrategy(aVar);
        this.izl = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.gRn = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.gRn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.o(1.0d);
        this.gRn.setImageProcessor(aVar2);
        this.izh = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.izh.aXI();
        this.izi = (TextView) view.findViewById(R.id.topic_comment_number);
        this.izj = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.izm = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.izn = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.izn.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.izn.setConrers(5);
        this.izn.setDrawCorner(true);
        this.izo = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dEL.setOnClickListener(this);
        this.izi.setOnClickListener(this);
        this.izj.setOnClickListener(this);
        this.izk.setOnClickListener(this);
        this.izm.setOnClickListener(this);
        this.izo.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.izd != null) {
            this.mSkinType = i;
            this.ize.setIsNight(this.mSkinType == 1);
            if (this.izd.iyo) {
                if (this.izd.iyn == 1) {
                    an.setImageResource(this.izf, R.drawable.label_topic_agree_red);
                    this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.izd.iyn == 2) {
                    an.setImageResource(this.izf, R.drawable.label_topic_disagree_blue);
                    this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    an.setImageResource(this.izf, R.drawable.label_topic_eat_black);
                    this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            an.setViewTextColor(this.dEL, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.izg, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.izi, (int) R.color.cp_cont_j);
            if (this.izj != null) {
                SvgManager.aWQ().a(this.izj, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.izh.onChangeSkinType(i);
            this.izk.setTextColor(an.getColor(R.color.cp_cont_b));
            an.c(this.izm, l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            an.setViewTextColor(this.izo, (int) R.color.cp_cont_d);
            this.gRn.onChangeSkinType();
            an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
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
        int aSg;
        AgreeData aUg;
        if (cVar != null && cVar.dLi != null) {
            this.izd = cVar;
            onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
            bu buVar = this.izd.dLi;
            PostData aTS = buVar.aTS();
            if (aTS != null) {
                this.ize.setPlaceHolder(1);
                if (this.izd.source == 1) {
                    this.ize.setData(buVar, false, true);
                } else {
                    this.ize.setData(buVar, false, false);
                }
                this.ize.setIsRound(true);
                this.ize.setBorderWidth(2);
                this.ize.setDrawBorder(true);
                this.ize.setPageId(this.dPv.getUniqueId());
                if (this.izd.iyo) {
                    this.izf.setVisibility(0);
                    if (this.izd.iyn == 1) {
                        this.izf.setImageResource(R.drawable.label_topic_agree_red);
                        this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.izd.iyn == 2) {
                        this.izf.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.izf.setImageResource(R.drawable.label_topic_eat_black);
                        this.ize.setBorderColor(this.dPv.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.izf.setVisibility(8);
                }
                if (this.izd.source == 1) {
                    name_show = aTS.aSp().getName_show();
                    formatTime = ar.getFormatTime(aTS.getTime());
                    aSg = aTS.did();
                } else {
                    name_show = buVar.aSp().getName_show();
                    formatTime = ar.getFormatTime(buVar.getCreateTime());
                    aSg = buVar.aSg();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dEL.setText(ar.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(buVar.aSt())) {
                    this.izg.setText(formatTime);
                } else {
                    this.izg.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), ar.cutChineseAndEnglishWithSuffix(buVar.aSt(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aWQ().a(this.izj, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = ar.numFormatOverWan(aSg);
                if (aSg > 0) {
                    this.izi.setVisibility(0);
                    this.izi.setText(numFormatOverWan);
                } else {
                    this.izi.setText(this.dPv.getString(R.string.action_comment_default));
                    this.izi.setVisibility(0);
                }
                if (this.izd.source == 1) {
                    aUg = aTS.aUg();
                    aUg.objType = 1;
                } else {
                    aUg = buVar.aUg();
                    aUg.objType = 3;
                }
                aUg.threadId = buVar.getTid();
                this.izh.setData(aUg);
                this.izh.setTopicId(String.valueOf(this.izd.topicId));
                a(aTS, buVar);
                a(cVar, buVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bu buVar) {
        if (this.izd.source == 1) {
            this.izk.setVisibility(0);
            this.izk.setText(postData.dib());
            return;
        }
        List<PbContent> aSf = buVar.aSf();
        if (w.getCount(aSf) > 0) {
            this.izk.setVisibility(0);
            this.izk.setText(TbRichTextView.a(getContext(), aSf, false));
            return;
        }
        SpannableString aTk = buVar.aTk();
        if (aTk != null && !StringUtils.isNull(aTk.toString())) {
            this.izk.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aTk);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.izk.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.izk.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bu buVar) {
        if (this.izd.source == 1) {
            this.izm.setVisibility(0);
            this.izl.setVisibility(8);
            String title = buVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.izm.setVisibility(8);
                return;
            }
            this.izm.setVisibility(0);
            this.izo.setText(title);
            String str = null;
            if (w.getCount(buVar.aSy()) != 0 && !w.isEmpty(cVar.dLi.aSy())) {
                Iterator<MediaData> it = cVar.dLi.aSy().iterator();
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
                an.setImageResource(this.izn, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.izn.setPlaceHolder(1);
            this.izn.startLoad(str, 10, false);
            return;
        }
        this.izm.setVisibility(8);
        this.izl.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bu buVar = cVar.dLi;
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.getCount(linkedList) > 0) {
                this.izl.setVisibility(0);
                this.gRn.setFromCDN(this.aik);
                this.gRn.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, buVar);
                        } else {
                            d.this.bdl();
                        }
                    }
                });
                this.gRn.setImageMediaList(linkedList);
                return;
            }
            this.izl.setVisibility(8);
            return;
        }
        this.izl.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.gRn != null) {
            this.gRn.setPageUniqueId(bdUniqueId);
        }
    }

    public void bdl() {
        if (this.izd != null && this.izd.dLi != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.dPv.getPageActivity()).createFromThreadCfg(this.izd.dLi, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.izd.dLi.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.izd.dLi.aSt());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.DO(this.izd.dLi.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void ckN() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.dPv.getPageActivity()).createNormalCfg(String.valueOf(this.izd.dLi.getTid()), String.format("%1$s", this.izd.dLi.aTS().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bu buVar) {
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
                    imageUrlData.urlType = this.aik ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(buVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, buVar.aSt(), String.valueOf(buVar.getFid()), buVar.getTid(), this.aik, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(buVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = buVar.getId();
        historyMessage.threadName = buVar.getTitle();
        historyMessage.forumName = buVar.aSt();
        historyMessage.postID = buVar.aSG();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.izd != null && this.izd.dLi != null) {
            if (view == this.izk) {
                if (this.izd.source == 1) {
                    ckN();
                } else {
                    bdl();
                }
                Gi("1");
            }
            if (view == this.izi || view == this.izj) {
                if (this.izd.source == 1) {
                    ckN();
                } else {
                    bdl();
                }
                Gi("3");
            } else if (view == this.dEL) {
                ckO();
            } else {
                bdl();
                Gi("2");
            }
        }
    }

    private void ckO() {
        MetaData aSp;
        if (this.izd != null && this.izd.dLi != null) {
            bu buVar = this.izd.dLi;
            if (this.izd.source == 1 && buVar.aTS() != null) {
                aSp = buVar.aTS().aSp();
            } else {
                aSp = buVar.aSp();
            }
            if (aSp != null && !StringUtils.isNull(aSp.getName_show()) && !StringUtils.isNull(aSp.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aSp.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aSp.isBigV());
                createNormalConfig.setSourceTid(buVar.getTid());
                createNormalConfig.setSourceNid(buVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Gi(String str) {
        TiebaStatic.log(new ao("c13356").dk("obj_locate", str).dk("tid", this.izd.dLi.getTid()).s("topic_id", this.izd.topicId).dk("obj_type", String.valueOf(this.izd.source)));
    }
}
