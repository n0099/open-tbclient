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
/* loaded from: classes22.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aEk;
    private TextView etx;
    private TextView idU;
    private TextView idV;
    private TextView idZ;
    private RelativeLayout ied;
    private TbImageView iee;
    private TbImageView ief;
    private TbImageView ieg;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bBn().dispatchMvcEvent(bVar);
                }
            }
        };
        this.etx = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.idU = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.idV = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.idZ = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.ied = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.iee = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.ief = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.ieg = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.iee.setOnClickListener(this.aEk);
        this.ief.setOnClickListener(this.aEk);
        this.ieg.setOnClickListener(this.aEk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(final tinfo tinfoVar) {
        super.au(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.etx.setVisibility(8);
            } else {
                this.etx.setVisibility(0);
                this.etx.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.etx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.idZ.setVisibility(8);
            } else {
                this.idZ.setVisibility(0);
                this.idZ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.idU.setVisibility(8);
            } else {
                this.idU.setVisibility(0);
                this.idU.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.idV.setVisibility(8);
            } else {
                this.idV.setVisibility(0);
                this.idV.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.biL().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.ied.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.ieg.setVisibility(0);
                        this.ieg.startLoad(str, 10, false);
                        this.ieg.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.ief.setVisibility(0);
                        this.ief.startLoad(str2, 10, false);
                        this.ief.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.iee.setVisibility(0);
                this.iee.startLoad(str3, 10, false);
                this.iee.setTag(0);
                return;
            }
            this.ied.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
