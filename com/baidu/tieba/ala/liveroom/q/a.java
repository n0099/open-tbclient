package com.baidu.tieba.ala.liveroom.q;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean aWs;
    private String avC;
    private TextView dsB;
    private TextView guC;
    private TextView guD;
    private TextView guE;
    private View guF;
    private View guG;
    private PersonUserData guH;
    private b guI;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0587a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void DP(String str);

        void DQ(String str);

        void DR(String str);

        void DS(String str);

        void DT(String str);

        void DU(String str);

        void bMe();

        void onCancel();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.guC = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.guF = findViewById(a.g.ala_person_forbid_this_divider);
        this.guD = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.guG = findViewById(a.g.ala_person_forbid_this_divider);
        this.guE = (TextView) findViewById(a.g.ala_person_admin);
        this.dsB = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.guC.setOnClickListener(this);
        this.guD.setOnClickListener(this);
        this.guE.setOnClickListener(this);
        this.dsB.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.guI != null) {
            if (view == this.guC) {
                if (this.guH != null && this.guH.user_info != null) {
                    if (bLY()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                            public void onConfirm() {
                                if (a.this.guH != null && a.this.guH.user_info != null) {
                                    a.this.guH.user_info.is_block = 0;
                                    a.this.guI.DR(a.this.guH.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.guH.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                        public void onConfirm() {
                            if (a.this.guH != null && a.this.guH.user_info != null) {
                                a.this.guH.user_info.is_block = 1;
                                a.this.guI.DP(a.this.guH.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.guH.user_info.getNameShow()));
                }
            } else if (view == this.guD) {
                if (this.guH != null && this.guH.user_info != null) {
                    if (bLX()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                            public void onConfirm() {
                                if (a.this.guH != null && a.this.guH.user_info != null) {
                                    a.this.guH.user_info.is_block = 0;
                                    a.this.guI.DS(a.this.guH.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.guH.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.4
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                        public void onConfirm() {
                            if (a.this.guH != null && a.this.guH.user_info != null) {
                                a.this.guH.user_info.is_block = 2;
                                a.this.guI.DQ(a.this.guH.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.guH.user_info.getNameShow()));
                }
            } else if (view == this.guE) {
                if (this.guH != null && this.guH.login_user_info != null) {
                    if (bLZ()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.5
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                            public void onConfirm() {
                                if (a.this.guH != null && a.this.guH.login_user_info != null) {
                                    a.this.guH.login_user_info.is_live_admin = 1;
                                    a.this.guI.DT(a.this.guH.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.guH.user_info.getNameShow()));
                    } else if (bMa()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.6
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                            public void onConfirm() {
                                if (a.this.guH != null && a.this.guH.login_user_info != null) {
                                    a.this.guH.login_user_info.is_live_admin = 0;
                                    a.this.guI.DU(a.this.guH.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.guH.user_info.getNameShow()));
                    } else if (bMb()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0587a() { // from class: com.baidu.tieba.ala.liveroom.q.a.7
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0587a
                            public void onConfirm() {
                                if (a.this.guH != null && a.this.guH.login_user_info != null) {
                                    a.this.guH.login_user_info.is_live_admin = 0;
                                    a.this.guI.bMe();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dsB) {
                this.guI.onCancel();
            }
        }
    }

    private void a(final InterfaceC0587a interfaceC0587a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0587a != null) {
                    interfaceC0587a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.guH = personUserData;
        this.aWs = z;
        this.avC = str;
        if (bMc() || bMd()) {
            sn(8);
            so(8);
        } else if (bLX()) {
            sn(8);
            this.guD.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bLY()) {
            sn(0);
            this.guC.setText(a.i.ala_person_relieve_forbidden_this);
            this.guD.setText(a.i.ala_person_forbid_forever);
        } else {
            sn(0);
            this.guC.setText(a.i.ala_person_forbid_this);
            this.guD.setText(a.i.ala_person_forbid_forever);
        }
        if (bLW()) {
            this.guE.setVisibility(8);
            this.guG.setVisibility(8);
        } else if (bMa()) {
            this.guE.setText(a.i.ala_person_fire_admin);
        } else if (bLZ()) {
            this.guE.setText(a.i.ala_person_appoint_admin);
        } else if (bMc() && bMb()) {
            this.guE.setText(a.i.ala_person_resign_admin);
        } else {
            this.guE.setVisibility(8);
            this.guG.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.guI = bVar;
    }

    private boolean bLW() {
        return (this.guH == null || this.guH.user_info == null || this.guH.user_info.is_block <= 0) ? false : true;
    }

    private boolean bLX() {
        return (this.guH == null || this.guH.user_info == null || this.guH.user_info.is_block != 2) ? false : true;
    }

    private boolean bLY() {
        return (this.guH == null || this.guH.user_info == null || this.guH.user_info.is_block != 1) ? false : true;
    }

    private boolean bLZ() {
        return this.guH != null && this.guH.user_info != null && this.aWs && this.guH.user_info.is_live_admin == 0;
    }

    private boolean bMa() {
        return this.guH != null && this.guH.user_info != null && this.aWs && this.guH.user_info.is_live_admin == 1;
    }

    private boolean bMb() {
        return (this.guH == null || this.guH.login_user_info == null || this.aWs || this.guH.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bMc() {
        return (this.guH == null || this.guH.user_info == null || TextUtils.isEmpty(this.avC) || !this.avC.equals(this.guH.user_info.user_id)) ? false : true;
    }

    private boolean bMd() {
        return (this.guH == null || this.guH.user_info == null || this.guH.user_info.is_live_admin != 1) ? false : true;
    }

    private void sn(int i) {
        this.guC.setVisibility(i);
        this.guF.setVisibility(i);
    }

    private void so(int i) {
        this.guD.setVisibility(i);
        this.guG.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
