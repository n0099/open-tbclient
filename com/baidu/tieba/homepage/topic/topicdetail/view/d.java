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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
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
    private boolean ajt;
    private TextView dTU;
    private TbPageContext efr;
    private ConstrainImageGroup hjP;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c iUn;
    private ClickableHeaderImageView iUo;
    private ImageView iUp;
    private TextView iUq;
    private AgreeView iUr;
    private TextView iUs;
    private ImageView iUt;
    private TbRichTextView iUu;
    private RelativeLayout iUv;
    private View iUw;
    private TbImageView iUx;
    private TextView iUy;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ajt = true;
        this.mSkinType = 3;
        this.efr = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iUo = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.iUp = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.dTU = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.iUq = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.iUu = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.iUu.setClickable(true);
        this.iUu.setTextEllipsize(TextUtils.TruncateAt.END);
        this.iUu.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.iUu.setLayoutStrategy(aVar);
        this.iUv = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hjP = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hjP.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.u(1.0d);
        this.hjP.setImageProcessor(aVar2);
        this.iUr = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.iUr.bke();
        this.iUs = (TextView) view.findViewById(R.id.topic_comment_number);
        this.iUt = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.iUw = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.iUx = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.iUx.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.iUx.setConrers(5);
        this.iUx.setDrawCorner(true);
        this.iUy = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.dTU.setOnClickListener(this);
        this.iUs.setOnClickListener(this);
        this.iUt.setOnClickListener(this);
        this.iUu.setOnClickListener(this);
        this.iUw.setOnClickListener(this);
        this.iUy.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hjP != null) {
            this.hjP.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hjP != null) {
            this.hjP.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.iUn != null) {
            this.mSkinType = i;
            this.iUo.setIsNight(this.mSkinType == 1);
            if (this.iUn.iTy) {
                if (this.iUn.iTx == 1) {
                    ap.setImageResource(this.iUp, R.drawable.label_topic_agree_red);
                    this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.iUn.iTx == 2) {
                    ap.setImageResource(this.iUp, R.drawable.label_topic_disagree_blue);
                    this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ap.setImageResource(this.iUp, R.drawable.label_topic_eat_black);
                    this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ap.setViewTextColor(this.dTU, R.color.cp_cont_b);
            ap.setViewTextColor(this.iUq, R.color.cp_cont_d);
            ap.setViewTextColor(this.iUs, R.color.cp_cont_j);
            if (this.iUt != null) {
                SvgManager.bjq().a(this.iUt, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.iUr.onChangeSkinType(i);
            this.iUu.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.c(this.iUw, l.getDimens(this.efr.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.iUy, R.color.cp_cont_d);
            this.hjP.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
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
        int bev;
        AgreeData bgv;
        if (cVar != null && cVar.dUW != null) {
            this.iUn = cVar;
            onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
            bw bwVar = this.iUn.dUW;
            PostData bgh = bwVar.bgh();
            if (bgh != null) {
                this.iUo.setPlaceHolder(1);
                if (this.iUn.source == 1) {
                    this.iUo.setData(bwVar, false, true);
                } else {
                    this.iUo.setData(bwVar, false, false);
                }
                this.iUo.setIsRound(true);
                this.iUo.setBorderWidth(2);
                this.iUo.setDrawBorder(true);
                this.iUo.setPageId(this.efr.getUniqueId());
                if (this.iUn.iTy) {
                    this.iUp.setVisibility(0);
                    if (this.iUn.iTx == 1) {
                        this.iUp.setImageResource(R.drawable.label_topic_agree_red);
                        this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.iUn.iTx == 2) {
                        this.iUp.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.iUp.setImageResource(R.drawable.label_topic_eat_black);
                        this.iUo.setBorderColor(this.efr.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.iUp.setVisibility(8);
                }
                if (this.iUn.source == 1) {
                    name_show = bgh.beE().getName_show();
                    formatTime = at.getFormatTime(bgh.getTime());
                    bev = bgh.dwO();
                } else {
                    name_show = bwVar.beE().getName_show();
                    formatTime = at.getFormatTime(bwVar.getCreateTime());
                    bev = bwVar.bev();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.dTU.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bwVar.beI())) {
                    this.iUq.setText(formatTime);
                } else {
                    this.iUq.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bwVar.beI(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bjq().a(this.iUt, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bev);
                if (bev > 0) {
                    this.iUs.setVisibility(0);
                    this.iUs.setText(numFormatOverWan);
                } else {
                    this.iUs.setText(this.efr.getString(R.string.action_comment_default));
                    this.iUs.setVisibility(0);
                }
                if (this.iUn.source == 1) {
                    bgv = bgh.bgv();
                    bgv.objType = 1;
                } else {
                    bgv = bwVar.bgv();
                    bgv.objType = 3;
                }
                bgv.threadId = bwVar.getTid();
                this.iUr.setData(bgv);
                this.iUr.setTopicId(String.valueOf(this.iUn.topicId));
                a(bgh, bwVar);
                a(cVar, bwVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bw bwVar) {
        if (this.iUn.source == 1) {
            this.iUu.setVisibility(0);
            this.iUu.setText(postData.dwM());
            return;
        }
        List<PbContent> beu = bwVar.beu();
        if (y.getCount(beu) > 0) {
            this.iUu.setVisibility(0);
            this.iUu.setText(TbRichTextView.a(getContext(), beu, false));
            return;
        }
        SpannableString bfz = bwVar.bfz();
        if (bfz != null && !StringUtils.isNull(bfz.toString())) {
            this.iUu.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bfz);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.iUu.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.iUu.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bw bwVar) {
        if (this.iUn.source == 1) {
            this.iUw.setVisibility(0);
            this.iUv.setVisibility(8);
            String title = bwVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.iUw.setVisibility(8);
                return;
            }
            this.iUw.setVisibility(0);
            this.iUy.setText(title);
            String str = null;
            if (y.getCount(bwVar.beN()) != 0 && !y.isEmpty(cVar.dUW.beN())) {
                Iterator<MediaData> it = cVar.dUW.beN().iterator();
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
                ap.setImageResource(this.iUx, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.iUx.setPlaceHolder(1);
            this.iUx.startLoad(str, 10, false);
            return;
        }
        this.iUw.setVisibility(8);
        this.iUv.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bw bwVar = cVar.dUW;
        ArrayList<MediaData> beN = bwVar.beN();
        if (k.bbM().isShowImages() && y.getCount(beN) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.iUv.setVisibility(0);
                this.hjP.setFromCDN(this.ajt);
                this.hjP.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bwVar);
                        } else {
                            d.this.bpF();
                        }
                    }
                });
                this.hjP.setImageMediaList(linkedList);
                return;
            }
            this.iUv.setVisibility(8);
            return;
        }
        this.iUv.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hjP != null) {
            this.hjP.setPageUniqueId(bdUniqueId);
        }
    }

    public void bpF() {
        if (this.iUn != null && this.iUn.dUW != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.efr.getPageActivity()).createFromThreadCfg(this.iUn.dUW, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.iUn.dUW.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.iUn.dUW.beI());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.GZ(this.iUn.dUW.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void czh() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.efr.getPageActivity()).createNormalCfg(String.valueOf(this.iUn.dUW.getTid()), String.format("%1$s", this.iUn.dUW.bgh().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bw bwVar) {
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
                    imageUrlData.urlType = this.ajt ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bwVar.getTid(), -1L);
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
        aVar.x(arrayList).mM(i).yQ(bwVar.beI()).yR(String.valueOf(bwVar.getFid())).yS(bwVar.getTid()).hI(this.ajt).yT(arrayList.size() > 0 ? arrayList.get(0) : "").hJ(true).a(concurrentHashMap).hK(true).r(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dP = aVar.dP(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dP.getIntent().putExtra("from", "index");
        } else {
            dP.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.beI();
        historyMessage.postID = bwVar.beV();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iUn != null && this.iUn.dUW != null) {
            if (view == this.iUu) {
                if (this.iUn.source == 1) {
                    czh();
                } else {
                    bpF();
                }
                JN("1");
            }
            if (view == this.iUs || view == this.iUt) {
                if (this.iUn.source == 1) {
                    czh();
                } else {
                    bpF();
                }
                JN("3");
            } else if (view == this.dTU) {
                czi();
            } else {
                bpF();
                JN("2");
            }
        }
    }

    private void czi() {
        MetaData beE;
        if (this.iUn != null && this.iUn.dUW != null) {
            bw bwVar = this.iUn.dUW;
            if (this.iUn.source == 1 && bwVar.bgh() != null) {
                beE = bwVar.bgh().beE();
            } else {
                beE = bwVar.beE();
            }
            if (beE != null && !StringUtils.isNull(beE.getName_show()) && !StringUtils.isNull(beE.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(beE.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), beE.isBigV());
                createNormalConfig.setSourceTid(bwVar.getTid());
                createNormalConfig.setSourceNid(bwVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void JN(String str) {
        TiebaStatic.log(new aq("c13356").dD("obj_locate", str).dD("tid", this.iUn.dUW.getTid()).u("topic_id", this.iUn.topicId).dD("obj_type", String.valueOf(this.iUn.source)));
    }
}
