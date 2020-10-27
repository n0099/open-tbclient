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
import com.baidu.tieba.card.n;
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
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean akk;
    private TbPageContext eCn;
    private TextView eqE;
    private ConstrainImageGroup hSj;
    private RelativeLayout jEA;
    private View jEB;
    private TbImageView jEC;
    private TextView jED;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c jEs;
    private ClickableHeaderImageView jEt;
    private ImageView jEu;
    private TextView jEv;
    private AgreeView jEw;
    private TextView jEx;
    private ImageView jEy;
    private TbRichTextView jEz;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akk = true;
        this.mSkinType = 3;
        this.eCn = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.jEt = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.jEu = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eqE = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.jEv = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.jEz = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.jEz.setClickable(true);
        this.jEz.setTextEllipsize(TextUtils.TruncateAt.END);
        this.jEz.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.jEz.setLayoutStrategy(aVar);
        this.jEA = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.hSj = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.hSj.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.y(1.0d);
        this.hSj.setImageProcessor(aVar2);
        this.jEw = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.jEw.bpC();
        this.jEx = (TextView) view.findViewById(R.id.topic_comment_number);
        this.jEy = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.jEB = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.jEC = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.jEC.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.jEC.setConrers(5);
        this.jEC.setDrawCorner(true);
        this.jED = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eqE.setOnClickListener(this);
        this.jEx.setOnClickListener(this);
        this.jEy.setOnClickListener(this);
        this.jEz.setOnClickListener(this);
        this.jEB.setOnClickListener(this);
        this.jED.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hSj != null) {
            this.hSj.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hSj != null) {
            this.hSj.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.jEs != null) {
            this.mSkinType = i;
            this.jEt.setIsNight(this.mSkinType == 1);
            if (this.jEs.jDD) {
                if (this.jEs.jDC == 1) {
                    ap.setImageResource(this.jEu, R.drawable.label_topic_agree_red);
                    this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.jEs.jDC == 2) {
                    ap.setImageResource(this.jEu, R.drawable.label_topic_disagree_blue);
                    this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    ap.setImageResource(this.jEu, R.drawable.label_topic_eat_black);
                    this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            ap.setViewTextColor(this.eqE, R.color.cp_cont_b);
            ap.setViewTextColor(this.jEv, R.color.cp_cont_d);
            ap.setViewTextColor(this.jEx, R.color.cp_cont_j);
            if (this.jEy != null) {
                SvgManager.boN().a(this.jEy, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.jEw.onChangeSkinType(i);
            this.jEz.setTextColor(ap.getColor(R.color.cp_cont_b));
            ap.c(this.jEB, l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.jED, R.color.cp_cont_d);
            this.hSj.onChangeSkinType();
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
        int bjR;
        AgreeData blR;
        if (cVar != null && cVar.erH != null) {
            this.jEs = cVar;
            onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
            bw bwVar = this.jEs.erH;
            PostData blD = bwVar.blD();
            if (blD != null) {
                this.jEt.setPlaceHolder(1);
                if (this.jEs.source == 1) {
                    this.jEt.setData(bwVar, false, true);
                } else {
                    this.jEt.setData(bwVar, false, false);
                }
                this.jEt.setIsRound(true);
                this.jEt.setBorderWidth(2);
                this.jEt.setDrawBorder(true);
                this.jEt.setPageId(this.eCn.getUniqueId());
                if (this.jEs.jDD) {
                    this.jEu.setVisibility(0);
                    if (this.jEs.jDC == 1) {
                        this.jEu.setImageResource(R.drawable.label_topic_agree_red);
                        this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.jEs.jDC == 2) {
                        this.jEu.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.jEu.setImageResource(R.drawable.label_topic_eat_black);
                        this.jEt.setBorderColor(this.eCn.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.jEu.setVisibility(8);
                }
                if (this.jEs.source == 1) {
                    name_show = blD.bka().getName_show();
                    formatTime = at.getFormatTime(blD.getTime());
                    bjR = blD.dHB();
                } else {
                    name_show = bwVar.bka().getName_show();
                    formatTime = at.getFormatTime(bwVar.getCreateTime());
                    bjR = bwVar.bjR();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eqE.setText(at.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bwVar.bke())) {
                    this.jEv.setText(formatTime);
                } else {
                    this.jEv.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), at.cutChineseAndEnglishWithSuffix(bwVar.bke(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.boN().a(this.jEy, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = at.numFormatOverWan(bjR);
                if (bjR > 0) {
                    this.jEx.setVisibility(0);
                    this.jEx.setText(numFormatOverWan);
                } else {
                    this.jEx.setText(this.eCn.getString(R.string.action_comment_default));
                    this.jEx.setVisibility(0);
                }
                if (this.jEs.source == 1) {
                    blR = blD.blR();
                    blR.objType = 1;
                } else {
                    blR = bwVar.blR();
                    blR.objType = 3;
                }
                blR.threadId = bwVar.getTid();
                this.jEw.setData(blR);
                this.jEw.setTopicId(String.valueOf(this.jEs.topicId));
                a(blD, bwVar);
                a(cVar, bwVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bw bwVar) {
        if (this.jEs.source == 1) {
            this.jEz.setVisibility(0);
            this.jEz.setText(postData.dHz());
            return;
        }
        List<PbContent> bjQ = bwVar.bjQ();
        if (y.getCount(bjQ) > 0) {
            this.jEz.setVisibility(0);
            this.jEz.setText(TbRichTextView.a(getContext(), bjQ, false));
            return;
        }
        SpannableString bkV = bwVar.bkV();
        if (bkV != null && !StringUtils.isNull(bkV.toString())) {
            this.jEz.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", bkV);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.jEz.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.jEz.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bw bwVar) {
        if (this.jEs.source == 1) {
            this.jEB.setVisibility(0);
            this.jEA.setVisibility(8);
            String title = bwVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.jEB.setVisibility(8);
                return;
            }
            this.jEB.setVisibility(0);
            this.jED.setText(title);
            String str = null;
            if (y.getCount(bwVar.bkj()) != 0 && !y.isEmpty(cVar.erH.bkj())) {
                Iterator<MediaData> it = cVar.erH.bkj().iterator();
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
                ap.setImageResource(this.jEC, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.jEC.setPlaceHolder(1);
            this.jEC.startLoad(str, 10, false);
            return;
        }
        this.jEB.setVisibility(8);
        this.jEA.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bw bwVar = cVar.erH;
        ArrayList<MediaData> bkj = bwVar.bkj();
        if (k.bhh().isShowImages() && y.getCount(bkj) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bkj.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bkj, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.jEA.setVisibility(0);
                this.hSj.setFromCDN(this.akk);
                this.hSj.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bwVar);
                        } else {
                            d.this.bvc();
                        }
                    }
                });
                this.hSj.setImageMediaList(linkedList);
                return;
            }
            this.jEA.setVisibility(8);
            return;
        }
        this.jEA.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.hSj != null) {
            this.hSj.setPageUniqueId(bdUniqueId);
        }
    }

    public void bvc() {
        if (this.jEs != null && this.jEs.erH != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eCn.getPageActivity()).createFromThreadCfg(this.jEs.erH, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.jEs.erH.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.jEs.erH.bke());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            n.II(this.jEs.erH.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cJE() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eCn.getPageActivity()).createNormalCfg(String.valueOf(this.jEs.erH.getTid()), String.format("%1$s", this.jEs.erH.blD().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.akk ? 13 : 14;
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
        aVar.x(arrayList).nF(i).Aq(bwVar.bke()).Ar(String.valueOf(bwVar.getFid())).As(bwVar.getTid()).io(this.akk).At(arrayList.size() > 0 ? arrayList.get(0) : "").ip(true).a(concurrentHashMap).iq(true).s(bwVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig dU = aVar.dU(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            dU.getIntent().putExtra("from", "index");
        } else {
            dU.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dU));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bwVar.getId();
        historyMessage.threadName = bwVar.getTitle();
        historyMessage.forumName = bwVar.bke();
        historyMessage.postID = bwVar.bkr();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jEs != null && this.jEs.erH != null) {
            if (view == this.jEz) {
                if (this.jEs.source == 1) {
                    cJE();
                } else {
                    bvc();
                }
                LC("1");
            }
            if (view == this.jEx || view == this.jEy) {
                if (this.jEs.source == 1) {
                    cJE();
                } else {
                    bvc();
                }
                LC("3");
            } else if (view == this.eqE) {
                cJF();
            } else {
                bvc();
                LC("2");
            }
        }
    }

    private void cJF() {
        MetaData bka;
        if (this.jEs != null && this.jEs.erH != null) {
            bw bwVar = this.jEs.erH;
            if (this.jEs.source == 1 && bwVar.blD() != null) {
                bka = bwVar.blD().bka();
            } else {
                bka = bwVar.bka();
            }
            if (bka != null && !StringUtils.isNull(bka.getName_show()) && !StringUtils.isNull(bka.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bka.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bka.isBigV());
                createNormalConfig.setSourceTid(bwVar.getTid());
                createNormalConfig.setSourceNid(bwVar.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void LC(String str) {
        TiebaStatic.log(new aq("c13356").dR("obj_locate", str).dR("tid", this.jEs.erH.getTid()).w("topic_id", this.jEs.topicId).dR("obj_type", String.valueOf(this.jEs.source)));
    }
}
