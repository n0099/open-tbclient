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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView abq;
    private View.OnClickListener bWZ;
    private TextView cGD;
    private RelativeLayout cGH;
    private TbImageView cGI;
    private TbImageView cGJ;
    private TbImageView cGK;
    private TextView cGy;
    private TextView cGz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.JT().dispatchMvcEvent(bVar);
                }
            }
        };
        this.abq = (TextView) view.findViewById(d.g.chosen_picture_title);
        this.cGy = (TextView) view.findViewById(d.g.chosen_picture_praise);
        this.cGz = (TextView) view.findViewById(d.g.chosen_picture_comment);
        this.cGD = (TextView) view.findViewById(d.g.chosen_picture_head);
        this.cGH = (RelativeLayout) view.findViewById(d.g.chosen_picture_pic_container);
        this.cGI = (TbImageView) view.findViewById(d.g.chosen_picture_pic_one);
        this.cGJ = (TbImageView) view.findViewById(d.g.chosen_picture_pic_two);
        this.cGK = (TbImageView) view.findViewById(d.g.chosen_picture_pic_thr);
        this.cGI.setOnClickListener(this.bWZ);
        this.cGJ.setOnClickListener(this.bWZ);
        this.cGK.setOnClickListener(this.bWZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.abq.setVisibility(8);
            } else {
                this.abq.setVisibility(0);
                this.abq.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.abq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ao.bc(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.cGD.setVisibility(8);
            } else {
                this.cGD.setVisibility(0);
                this.cGD.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.cGy.setVisibility(8);
            } else {
                this.cGy.setVisibility(0);
                this.cGy.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cGz.setVisibility(8);
            } else {
                this.cGz.setVisibility(0);
                this.cGz.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.tt().tz() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.cGH.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.cGK.setVisibility(0);
                        this.cGK.startLoad(str, 10, false);
                        this.cGK.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.cGJ.setVisibility(0);
                        this.cGJ.startLoad(str2, 10, false);
                        this.cGJ.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.cGI.setVisibility(0);
                this.cGI.startLoad(str3, 10, false);
                this.cGI.setTag(0);
                return;
            }
            this.cGH.setVisibility(8);
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
