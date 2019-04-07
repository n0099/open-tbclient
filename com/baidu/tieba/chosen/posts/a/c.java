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
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView buc;
    private View.OnClickListener dIo;
    private TextView eqf;
    private TextView eqg;
    private TextView eqk;
    private RelativeLayout eqo;
    private TbImageView eqp;
    private TbImageView eqq;
    private TbImageView eqr;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dIo = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aoG().dispatchMvcEvent(bVar);
                }
            }
        };
        this.buc = (TextView) view.findViewById(d.g.chosen_picture_title);
        this.eqf = (TextView) view.findViewById(d.g.chosen_picture_praise);
        this.eqg = (TextView) view.findViewById(d.g.chosen_picture_comment);
        this.eqk = (TextView) view.findViewById(d.g.chosen_picture_head);
        this.eqo = (RelativeLayout) view.findViewById(d.g.chosen_picture_pic_container);
        this.eqp = (TbImageView) view.findViewById(d.g.chosen_picture_pic_one);
        this.eqq = (TbImageView) view.findViewById(d.g.chosen_picture_pic_two);
        this.eqr = (TbImageView) view.findViewById(d.g.chosen_picture_pic_thr);
        this.eqp.setOnClickListener(this.dIo);
        this.eqq.setOnClickListener(this.dIo);
        this.eqr.setOnClickListener(this.dIo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ad(final tinfo tinfoVar) {
        super.ad(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.buc.setVisibility(8);
            } else {
                this.buc.setVisibility(0);
                this.buc.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.buc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (ap.bv(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.eqk.setVisibility(8);
            } else {
                this.eqk.setVisibility(0);
                this.eqk.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eqf.setVisibility(8);
            } else {
                this.eqf.setVisibility(0);
                this.eqf.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eqg.setVisibility(8);
            } else {
                this.eqg.setVisibility(0);
                this.eqg.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.Wv().Wz() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eqo.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eqr.setVisibility(0);
                        this.eqr.startLoad(str, 10, false);
                        this.eqr.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eqq.setVisibility(0);
                        this.eqq.startLoad(str2, 10, false);
                        this.eqq.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eqp.setVisibility(0);
                this.eqp.startLoad(str3, 10, false);
                this.eqp.setTag(0);
                return;
            }
            this.eqo.setVisibility(8);
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
