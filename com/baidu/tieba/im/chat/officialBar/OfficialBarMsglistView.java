package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout jbg;
    private TextView kjm;
    private ImageView kmQ;
    private LinearLayout kmR;
    private LinearLayout kmS;
    private OfficialSecondMenuPopupWindow kmT;
    private a[] kmU;
    private boolean kmV;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kmV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.kjm = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kjm.setText(string);
        }
        this.jbg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.jbg.setVisibility(0);
        this.kmQ = (ImageView) this.jbg.findViewById(R.id.official_bar_toggle_button);
        this.kmQ.setVisibility(0);
        this.kmU = new a[3];
        a aVar = new a();
        aVar.bvS = false;
        aVar.kmZ = (LinearLayout) this.jbg.findViewById(R.id.menu_frist);
        aVar.kna = (TextView) this.jbg.findViewById(R.id.menu_frist_text);
        aVar.knb = (ImageView) this.jbg.findViewById(R.id.menu_frist_tip);
        this.kmU[0] = aVar;
        a aVar2 = new a();
        aVar2.bvS = false;
        aVar2.kmZ = (LinearLayout) this.jbg.findViewById(R.id.menu_second);
        aVar2.kna = (TextView) this.jbg.findViewById(R.id.menu_second_text);
        aVar2.knb = (ImageView) this.jbg.findViewById(R.id.menu_second_tip);
        this.kmU[1] = aVar2;
        a aVar3 = new a();
        aVar3.bvS = false;
        aVar3.kmZ = (LinearLayout) this.jbg.findViewById(R.id.menu_third);
        aVar3.kna = (TextView) this.jbg.findViewById(R.id.menu_third_text);
        aVar3.knb = (ImageView) this.jbg.findViewById(R.id.menu_third_tip);
        this.kmU[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.kmU[i].kmZ.setOnClickListener(talkableActivity);
        }
        this.kmR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.kmR.setVisibility(0);
        this.kmS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.kmS.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.sg(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.kmT = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.kmT);
        this.kmT.setVisibility(8);
        this.kmT.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.kmV = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0207);
        this.mTool.ks(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fub != null && (this.mSendTool.fub instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fub;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fuU = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bE(arrayList);
        m sj = this.mTool.sj(5);
        if (sj != null) {
            sj.fuU = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fub != null && (aVar.fub instanceof EditText)) {
            ((EditText) aVar.fub).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.kmV) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.build();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.kmV) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.sg(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cUb() {
        return this.kmT;
    }

    public void ai(boolean z, boolean z2) {
        if (this.kmV != z) {
            if (!this.kmV) {
                this.mTool.ku(false);
                return;
            }
            this.jbg.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.kmR.setVisibility(0);
            return;
        }
        this.kmV = !z;
        if (z) {
            this.jbg.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.ku(true);
                } else {
                    this.mTool.ku(false);
                }
            }
            this.kmR.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.jbg.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.kmR.setVisibility(0);
    }

    public a[] cUc() {
        return this.kmU;
    }

    public void ek(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.kmU[i].kna.setText(bVar.getName());
                if (bVar.cVH() != 0) {
                    this.kmU[i].knb.setVisibility(8);
                }
            }
        }
    }

    public void sf(boolean z) {
        this.kmS.setVisibility(z ? 0 : 8);
    }

    public void sg(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    OfficialBarMsglistView.this.jbg.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.jbg.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.su();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.kmU[i];
                        if (aVar.bvS) {
                            aVar.bvS = false;
                            OfficialBarMsglistView.this.aa(i, aVar.bvS);
                            OfficialBarMsglistView.this.kmT.Wd();
                        }
                    }
                }
                OfficialBarMsglistView.this.getLayoutBottom().startAnimation(loadAnimation);
            }
        });
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void aa(int i, boolean z) {
        a aVar = this.kmU[i];
        if (z) {
            aVar.knb.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.kna.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        aVar.knb.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.kna.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
    }

    public int df(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.kmU[i].kmZ) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class a {
        boolean bvS;
        LinearLayout kmZ;
        TextView kna;
        ImageView knb;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void DN(int i) {
        if (this.kjm != null) {
            this.kjm.setText(i);
        }
    }

    public void cUd() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.kjm, R.color.CAM_X0302, 1);
    }
}
