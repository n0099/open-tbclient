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
/* loaded from: classes8.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aEh;
    private RelativeLayout bpa;
    private TextView eHx;
    private TextView iCn;
    private TextView iCo;
    private TextView iCs;
    private TbImageView iCw;
    private TbImageView iCx;
    private TbImageView iCy;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bDI().dispatchMvcEvent(bVar);
                }
            }
        };
        this.eHx = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.iCn = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.iCo = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.iCs = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.bpa = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.iCw = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.iCx = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.iCy = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.iCw.setOnClickListener(this.aEh);
        this.iCx.setOnClickListener(this.aEh);
        this.iCy.setOnClickListener(this.aEh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(final tinfo tinfoVar) {
        super.aw(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eHx.setVisibility(8);
            } else {
                this.eHx.setVisibility(0);
                this.eHx.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.iCs.setVisibility(8);
            } else {
                this.iCs.setVisibility(0);
                this.iCs.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.iCn.setVisibility(8);
            } else {
                this.iCn.setVisibility(0);
                this.iCn.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.iCo.setVisibility(8);
            } else {
                this.iCo.setVisibility(0);
                this.iCo.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bkT().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.bpa.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.iCy.setVisibility(0);
                        this.iCy.startLoad(str, 10, false);
                        this.iCy.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.iCx.setVisibility(0);
                        this.iCx.startLoad(str2, 10, false);
                        this.iCx.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.iCw.setVisibility(0);
                this.iCw.startLoad(str3, 10, false);
                this.iCw.setTag(0);
                return;
            }
            this.bpa.setVisibility(8);
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
