package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aFH;
    private RelativeLayout bqA;
    private TextView eIY;
    private TextView iEk;
    private TextView iEl;
    private TextView iEp;
    private TbImageView iEt;
    private TbImageView iEu;
    private TbImageView iEv;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bDL().dispatchMvcEvent(bVar);
                }
            }
        };
        this.eIY = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.iEk = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.iEl = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.iEp = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.bqA = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.iEt = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.iEu = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.iEv = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.iEt.setOnClickListener(this.aFH);
        this.iEu.setOnClickListener(this.aFH);
        this.iEv.setOnClickListener(this.aFH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ay(final tinfo tinfoVar) {
        super.ay(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eIY.setVisibility(8);
            } else {
                this.eIY.setVisibility(0);
                this.eIY.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (au.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.iEp.setVisibility(8);
            } else {
                this.iEp.setVisibility(0);
                this.iEp.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.iEk.setVisibility(8);
            } else {
                this.iEk.setVisibility(0);
                this.iEk.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.iEl.setVisibility(8);
            } else {
                this.iEl.setVisibility(0);
                this.iEl.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bkV().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.bqA.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.iEv.setVisibility(0);
                        this.iEv.startLoad(str, 10, false);
                        this.iEv.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.iEu.setVisibility(0);
                        this.iEu.startLoad(str2, 10, false);
                        this.iEu.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.iEt.setVisibility(0);
                this.iEt.startLoad(str3, 10, false);
                this.iEt.setTag(0);
                return;
            }
            this.bqA.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
