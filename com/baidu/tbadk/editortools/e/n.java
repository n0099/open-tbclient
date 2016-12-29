package com.baidu.tbadk.editortools.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.editortools.d {
    private a<?> awv;
    private String forumName = null;
    private String forumId = null;
    private String from = null;
    private boolean awu = false;

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void a(a<?> aVar) {
        this.awv = aVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f am(Context context) {
        com.baidu.tbadk.editortools.j jVar = new com.baidu.tbadk.editortools.j(context);
        jVar.setBackgroundColorId(0);
        jVar.setBarBackgroundColorId(r.d.common_color_10099);
        jVar.bD(true);
        e eVar = new e(jVar);
        eVar.a(this.awv);
        return eVar;
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof e) {
            com.baidu.tbadk.editortools.j CB = fVar.CB();
            o oVar = new o(this, (e) fVar, CB);
            CB.a(5, oVar);
            CB.a(4, oVar);
            CB.a(7, oVar);
            CB.a(16, oVar);
            CB.a(14, oVar);
            CB.a(15, oVar);
            CB.a(8, oVar);
            CB.a(18, oVar);
            CB.a(20, oVar);
            CB.a(10, oVar);
            CB.a(11, oVar);
            CB.a(27, oVar);
            CB.a(29, oVar);
            CB.a(36, oVar);
            CB.a(32, oVar);
            CB.a(40, oVar);
            CB.a(43, oVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        CustomResponsedMessage runTask;
        x xVar;
        com.baidu.tbadk.editortools.j CB = fVar.CB();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(19);
        arrayList.add(20);
        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(6);
        arrayList.add(9);
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(CB.getContext(), 7);
        CB.b(aVar);
        aVar.auR = r.f.icon_topic_n;
        CB.b(new com.baidu.tbadk.editortools.imagetool.i(CB.getContext(), 3));
        CB.b(new com.baidu.tbadk.editortools.imagetool.b(CB.getContext()));
        if (com.baidu.tieba.tbadkCore.voice.c.bhh() && com.baidu.tieba.tbadkCore.t.a(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_VOICE_RECORDER_CTRL, CB.getContext()), x.class)) != null && (xVar = (x) runTask.getData()) != null) {
            xVar.auT = 4;
            CB.b(xVar);
        }
        CB.b(new com.baidu.tbadk.editortools.a.a(CB.getContext(), 5));
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_TOOL_CRTL, CB.getContext()), x.class);
        if (runTask2 != null && (runTask2.getData() instanceof x)) {
            x xVar2 = (x) runTask2.getData();
            xVar2.auT = 6;
            CB.b(xVar2);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, CB.getContext()), x.class);
        if (runTask3 != null && runTask3.getData() != null) {
            x xVar3 = (x) runTask3.getData();
            xVar3.auT = 8;
            CB.b(xVar3);
        }
        CB.b(new com.baidu.tbadk.editortools.inputtool.a(CB.getContext(), true));
        CB.b(new com.baidu.tbadk.editortools.sendtool.a(CB.getContext()));
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, CB.getContext()), x.class);
        if (runTask4 != null && runTask4.getData() != null) {
            x xVar4 = (x) runTask4.getData();
            xVar4.auT = 9;
            CB.b(xVar4);
        }
        arrayList.add(7);
        arrayList.add(8);
        CB.y(arrayList);
        if (!"PbChosenActivity".equals(CB.getContext().getClass().getSimpleName())) {
            CB.b(new com.baidu.tbadk.editortools.b.a(CB.getContext(), 10));
        }
        CB.CC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(r.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }
}
