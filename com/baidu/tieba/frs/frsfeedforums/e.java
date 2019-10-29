package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> cfl;
    private LikeModel csF;
    private List<FeedForumData> fGD;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.cfl.getOrignalPage()).checkUpIsLogin()) {
                        e.this.csF.dY(feedForumData.getForumName(), feedForumData.getForumId());
                        an anVar = new an("c10048");
                        anVar.bS("fid", feedForumData.getForumId());
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(anVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.cfl.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new an("c10050").bS("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d fbU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.aH(e.this.csF.getErrorCode(), e.this.csF.getErrorString())) {
                AntiHelper.aS(e.this.cfl.getPageActivity(), e.this.csF.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.csF.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.csF.getErrorString());
                }
            } else {
                t tVar = (t) obj;
                tVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.cfl = tbPageContext;
        this.csF = new LikeModel(tbPageContext);
        this.csF.setLoadDataCallBack(this.fbU);
    }

    public void setData(List<FeedForumData> list) {
        this.fGD = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fGD != null) {
            return this.fGD.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fGD != null) {
            return this.fGD.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.fGL.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.djw.setOnClickListener(this.mOnClickListener);
        bVar.fGI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.fGI.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.fGJ.setText(String.format(this.cfl.getPageActivity().getString(R.string.attention_post_count), qZ(feedForumData.getMemberCount()), qZ(feedForumData.getPostNum())));
        bVar.fGK.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.fGL.setClickable(true);
            bVar.fGL.setOnClickListener(this.mOnClickListener);
            bVar.fGL.setEnabled(true);
            bVar.fGL.ew(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.csX != this.mSkinType) {
            am.setBackgroundResource(bVar.djw, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.fGJ, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.fGK, R.color.cp_link_tip_d, 1);
            if (bVar.bhm != null) {
                am.setBackgroundColor(bVar.bhm, R.color.cp_bg_line_c);
            }
            bVar.csX = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.fGL != null) {
            bVar.fGL.ew(true);
            bVar.fGL.setEnabled(false);
        }
    }

    private String qZ(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    public void a(List<FeedForumData> list, t tVar) {
        if (list != null && list.size() > 0 && tVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(tVar.getFid())) {
                    feedForumData.setIsLike(tVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
