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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aaW;
    private TextView cGX;
    private TextView cGY;
    private TextView cHc;
    private RelativeLayout cHg;
    private TbImageView cHh;
    private TbImageView cHi;
    private TbImageView cHj;
    private View.OnClickListener cas;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.Kg().dispatchMvcEvent(bVar);
                }
            }
        };
        this.aaW = (TextView) view.findViewById(d.g.chosen_picture_title);
        this.cGX = (TextView) view.findViewById(d.g.chosen_picture_praise);
        this.cGY = (TextView) view.findViewById(d.g.chosen_picture_comment);
        this.cHc = (TextView) view.findViewById(d.g.chosen_picture_head);
        this.cHg = (RelativeLayout) view.findViewById(d.g.chosen_picture_pic_container);
        this.cHh = (TbImageView) view.findViewById(d.g.chosen_picture_pic_one);
        this.cHi = (TbImageView) view.findViewById(d.g.chosen_picture_pic_two);
        this.cHj = (TbImageView) view.findViewById(d.g.chosen_picture_pic_thr);
        this.cHh.setOnClickListener(this.cas);
        this.cHi.setOnClickListener(this.cas);
        this.cHj.setOnClickListener(this.cas);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.aaW.setVisibility(8);
            } else {
                this.aaW.setVisibility(0);
                this.aaW.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.aaW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ap.bf(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.cHc.setVisibility(8);
            } else {
                this.cHc.setVisibility(0);
                this.cHc.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cGX.setVisibility(8);
            } else {
                this.cGX.setVisibility(0);
                this.cGX.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cGY.setVisibility(8);
            } else {
                this.cGY.setVisibility(0);
                this.cGY.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.te().tk() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cHg.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cHj.setVisibility(0);
                        this.cHj.startLoad(str, 10, false);
                        this.cHj.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cHi.setVisibility(0);
                        this.cHi.startLoad(str2, 10, false);
                        this.cHi.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cHh.setVisibility(0);
                this.cHh.startLoad(str3, 10, false);
                this.cHh.setTag(0);
                return;
            }
            this.cHg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
