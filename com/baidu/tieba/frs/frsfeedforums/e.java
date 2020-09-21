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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> ehG;
    private LikeModel ezi;
    private List<FeedForumData> ioe;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.ehG.getOrignalPage()).checkUpIsLogin()) {
                        e.this.ezi.gd(feedForumData.getForumName(), feedForumData.getForumId());
                        aq aqVar = new aq("c10048");
                        aqVar.dF("fid", feedForumData.getForumId());
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aqVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.ehG.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new aq("c10050").dF("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hCF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bC(e.this.ezi.getErrorCode(), e.this.ezi.getErrorString())) {
                AntiHelper.bh(e.this.ehG.getPageActivity(), e.this.ezi.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.ezi.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.ezi.getErrorString());
                }
            } else {
                v vVar = (v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.ehG = tbPageContext;
        this.ezi = new LikeModel(tbPageContext);
        this.ezi.setLoadDataCallBack(this.hCF);
    }

    public void setData(List<FeedForumData> list) {
        this.ioe = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ioe != null) {
            return this.ioe.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ioe != null) {
            return this.ioe.get(i);
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
            view = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.iom.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.ftd.setOnClickListener(this.mOnClickListener);
        bVar.ioj.setPlaceHolder(1);
        bVar.ioj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.ioj.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.iok.setText(String.format(this.ehG.getPageActivity().getString(R.string.attention_post_count), yp(feedForumData.getMemberCount()), yp(feedForumData.getPostNum())));
        bVar.iol.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.iom.setClickable(true);
            bVar.iom.setOnClickListener(this.mOnClickListener);
            bVar.iom.setEnabled(true);
            bVar.iom.aN(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.aiX != this.mSkinType) {
            ap.setBackgroundResource(bVar.ftd, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.iok, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.iol, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                ap.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.aiX = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.iom != null) {
            bVar.iom.aN(true);
            bVar.iom.setEnabled(false);
        }
    }

    private String yp(int i) {
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

    public void a(List<FeedForumData> list, v vVar) {
        if (list != null && list.size() > 0 && vVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(vVar.getFid())) {
                    feedForumData.setIsLike(vVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
