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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout fDb;
    private TextView gAL;
    private ImageView gDN;
    private LinearLayout gDO;
    private LinearLayout gDP;
    private OfficialSecondMenuPopupWindow gDQ;
    private a[] gDR;
    private boolean gDS;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gDS = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.gAL = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gAL.setText(string);
        }
        this.fDb = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.fDb.setVisibility(0);
        this.gDN = (ImageView) this.fDb.findViewById(R.id.official_bar_toggle_button);
        this.gDN.setVisibility(0);
        this.gDR = new a[3];
        a aVar = new a();
        aVar.gDW = false;
        aVar.gDX = (LinearLayout) this.fDb.findViewById(R.id.menu_frist);
        aVar.gDY = (TextView) this.fDb.findViewById(R.id.menu_frist_text);
        aVar.gDZ = (ImageView) this.fDb.findViewById(R.id.menu_frist_tip);
        this.gDR[0] = aVar;
        a aVar2 = new a();
        aVar2.gDW = false;
        aVar2.gDX = (LinearLayout) this.fDb.findViewById(R.id.menu_second);
        aVar2.gDY = (TextView) this.fDb.findViewById(R.id.menu_second_text);
        aVar2.gDZ = (ImageView) this.fDb.findViewById(R.id.menu_second_tip);
        this.gDR[1] = aVar2;
        a aVar3 = new a();
        aVar3.gDW = false;
        aVar3.gDX = (LinearLayout) this.fDb.findViewById(R.id.menu_third);
        aVar3.gDY = (TextView) this.fDb.findViewById(R.id.menu_third_text);
        aVar3.gDZ = (ImageView) this.fDb.findViewById(R.id.menu_third_tip);
        this.gDR[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.gDR[i].gDX.setOnClickListener(talkableActivity);
        }
        this.gDO = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.gDO.setVisibility(0);
        this.gDP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.gDP.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gDN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.lT(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.gDQ = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.gDQ);
        this.gDQ.setVisibility(8);
        this.gDQ.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.gDS = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.fk(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, k.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (k) runTask.getData();
            if (this.mSendTool.csV != null && (this.mSendTool.csV instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.csV;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.ctM = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.ai(arrayList);
        k kt = this.mTool.kt(5);
        if (kt != null) {
            kt.ctM = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.csV != null && (aVar.csV instanceof EditText)) {
            ((EditText) aVar.csV).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.gDS) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.asn();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.gDS) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.lT(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow bBN() {
        return this.gDQ;
    }

    public void S(boolean z, boolean z2) {
        if (this.gDS != z) {
            if (!this.gDS) {
                this.mTool.fm(false);
                return;
            }
            this.fDb.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.gDO.setVisibility(0);
            return;
        }
        this.gDS = !z;
        if (z) {
            this.fDb.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.fm(true);
                } else {
                    this.mTool.fm(false);
                }
            }
            this.gDO.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.fDb.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.gDO.setVisibility(0);
    }

    public a[] bBO() {
        return this.gDR;
    }

    public void cP(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.gDR[i].gDY.setText(bVar.getName());
                if (bVar.bDt() != 0) {
                    this.gDR[i].gDZ.setVisibility(8);
                }
            }
        }
    }

    public void lS(boolean z) {
        this.gDP.setVisibility(z ? 0 : 8);
    }

    public void lT(final boolean z) {
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
                    OfficialBarMsglistView.this.fDb.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.fDb.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.ql();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.gDR[i];
                        if (aVar.gDW) {
                            aVar.gDW = false;
                            OfficialBarMsglistView.this.K(i, aVar.gDW);
                            OfficialBarMsglistView.this.gDQ.bhx();
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

    public void K(int i, boolean z) {
        a aVar = this.gDR[i];
        if (z) {
            aVar.gDZ.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.gDY.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.gDZ.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.gDY.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int ch(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.gDR[i].gDX) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        boolean gDW;
        LinearLayout gDX;
        TextView gDY;
        ImageView gDZ;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void vm(int i) {
        if (this.gAL != null) {
            this.gAL.setText(i);
        }
    }

    public void bBP() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.f(this.gAL, R.color.cp_link_tip_a, 1);
    }
}
