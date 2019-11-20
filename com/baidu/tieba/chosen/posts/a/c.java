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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener ajc;
    private TextView bUf;
    private TbImageView eUA;
    private TbImageView eUB;
    private TbImageView eUC;
    private TextView eUq;
    private TextView eUr;
    private TextView eUv;
    private RelativeLayout eUz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.awv().dispatchMvcEvent(bVar);
                }
            }
        };
        this.bUf = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.eUq = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.eUr = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.eUv = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.eUz = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.eUA = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.eUB = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.eUC = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.eUA.setOnClickListener(this.ajc);
        this.eUB.setOnClickListener(this.ajc);
        this.eUC.setOnClickListener(this.ajc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(final tinfo tinfoVar) {
        super.ab(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.bUf.setVisibility(8);
            } else {
                this.bUf.setVisibility(0);
                this.bUf.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.bUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.eUv.setVisibility(8);
            } else {
                this.eUv.setVisibility(0);
                this.eUv.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eUq.setVisibility(8);
            } else {
                this.eUq.setVisibility(0);
                this.eUq.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eUr.setVisibility(8);
            } else {
                this.eUr.setVisibility(0);
                this.eUr.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.ago().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eUz.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eUC.setVisibility(0);
                        this.eUC.startLoad(str, 10, false);
                        this.eUC.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eUB.setVisibility(0);
                        this.eUB.startLoad(str2, 10, false);
                        this.eUB.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eUA.setVisibility(0);
                this.eUA.startLoad(str3, 10, false);
                this.eUA.setTag(0);
                return;
            }
            this.eUz.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
