package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aIe;
    private View.OnClickListener cyh;
    private TextView dfi;
    private TextView dfj;
    private TextView dfn;
    private RelativeLayout dfr;
    private TbImageView dfs;
    private TbImageView dft;
    private TbImageView dfu;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.NL().dispatchMvcEvent(bVar);
                }
            }
        };
        this.aIe = (TextView) view.findViewById(d.g.chosen_picture_title);
        this.dfi = (TextView) view.findViewById(d.g.chosen_picture_praise);
        this.dfj = (TextView) view.findViewById(d.g.chosen_picture_comment);
        this.dfn = (TextView) view.findViewById(d.g.chosen_picture_head);
        this.dfr = (RelativeLayout) view.findViewById(d.g.chosen_picture_pic_container);
        this.dfs = (TbImageView) view.findViewById(d.g.chosen_picture_pic_one);
        this.dft = (TbImageView) view.findViewById(d.g.chosen_picture_pic_two);
        this.dfu = (TbImageView) view.findViewById(d.g.chosen_picture_pic_thr);
        this.dfs.setOnClickListener(this.cyh);
        this.dft.setOnClickListener(this.cyh);
        this.dfu.setOnClickListener(this.cyh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(final tinfo tinfoVar) {
        super.aI(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aIe.setVisibility(8);
            } else {
                this.aIe.setVisibility(0);
                this.aIe.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (am.aT(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.dfn.setVisibility(8);
            } else {
                this.dfn.setVisibility(0);
                this.dfn.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.dfi.setVisibility(8);
            } else {
                this.dfi.setVisibility(0);
                this.dfi.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.dfj.setVisibility(8);
            } else {
                this.dfj.setVisibility(0);
                this.dfj.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.xo().xu() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.dfr.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.dfu.setVisibility(0);
                        this.dfu.startLoad(str, 10, false);
                        this.dfu.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.dft.setVisibility(0);
                        this.dft.startLoad(str2, 10, false);
                        this.dft.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.dfs.setVisibility(0);
                this.dfs.startLoad(str3, 10, false);
                this.dfs.setTag(0);
                return;
            }
            this.dfr.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.aQ(i == 1);
        layoutMode.aM(getRootView());
        return true;
    }
}
