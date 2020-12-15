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
/* loaded from: classes23.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aGQ;
    private RelativeLayout boJ;
    private TextView eAz;
    private TextView ioQ;
    private TextView ioR;
    private TextView ioV;
    private TbImageView ioZ;
    private TbImageView ipa;
    private TbImageView ipb;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bEP().dispatchMvcEvent(bVar);
                }
            }
        };
        this.eAz = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.ioQ = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.ioR = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.ioV = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.boJ = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.ioZ = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.ipa = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.ipb = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.ioZ.setOnClickListener(this.aGQ);
        this.ipa.setOnClickListener(this.aGQ);
        this.ipb.setOnClickListener(this.aGQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(final tinfo tinfoVar) {
        super.au(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eAz.setVisibility(8);
            } else {
                this.eAz.setVisibility(0);
                this.eAz.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.ioV.setVisibility(8);
            } else {
                this.ioV.setVisibility(0);
                this.ioV.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.ioQ.setVisibility(8);
            } else {
                this.ioQ.setVisibility(0);
                this.ioQ.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.ioR.setVisibility(8);
            } else {
                this.ioR.setVisibility(0);
                this.ioR.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.blV().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.boJ.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.ipb.setVisibility(0);
                        this.ipb.startLoad(str, 10, false);
                        this.ipb.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.ipa.setVisibility(0);
                        this.ipa.startLoad(str2, 10, false);
                        this.ipa.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.ioZ.setVisibility(0);
                this.ioZ.startLoad(str3, 10, false);
                this.ioZ.setTag(0);
                return;
            }
            this.boJ.setVisibility(8);
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
