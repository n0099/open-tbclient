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
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aFb;
    private TextView bZE;
    private boolean bpf;
    private TextView hOS;
    private TextView hOT;
    private TextView hOU;
    private View hOV;
    private View hOW;
    private PersonUserData hOX;
    private b hOY;
    private int hOZ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0678a {
        void onConfirm();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void aN(String str, int i);

        void aO(String str, int i);

        void aP(String str, int i);

        void aQ(String str, int i);

        void aR(String str, int i);

        void aS(String str, int i);

        void onCancel();

        void wg(int i);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.hOZ = 0;
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hOS = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hOV = findViewById(a.f.ala_person_forbid_this_divider);
        this.hOT = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hOW = findViewById(a.f.ala_person_forbid_this_divider);
        this.hOU = (TextView) findViewById(a.f.ala_person_admin);
        this.bZE = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hOS.setOnClickListener(this);
        this.hOT.setOnClickListener(this);
        this.hOU.setOnClickListener(this);
        this.bZE.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hOY != null) {
            if (view == this.hOS) {
                if (this.hOX != null && this.hOX.user_info != null) {
                    if (ckq()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    a.this.hOX.user_info.is_block = 0;
                                    a.this.hOY.aP(a.this.hOX.user_info.user_id, a.this.hOZ);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hOX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                        public void onConfirm() {
                            if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                a.this.hOX.user_info.is_block = 1;
                                a.this.hOY.aN(a.this.hOX.user_info.user_id, a.this.hOZ);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hOX.user_info.getNameShow()));
                }
            } else if (view == this.hOT) {
                if (this.hOX != null && this.hOX.user_info != null) {
                    if (ckp()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.3
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                    a.this.hOX.user_info.is_block = 0;
                                    a.this.hOY.aQ(a.this.hOX.user_info.user_id, a.this.hOZ);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hOX.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.4
                        @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                        public void onConfirm() {
                            if (a.this.hOX != null && a.this.hOX.user_info != null) {
                                a.this.hOX.user_info.is_block = 2;
                                a.this.hOY.aO(a.this.hOX.user_info.user_id, a.this.hOZ);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hOX.user_info.getNameShow()));
                }
            } else if (view == this.hOU) {
                if (this.hOX != null && this.hOX.login_user_info != null) {
                    if (ckr()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.5
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.login_user_info != null) {
                                    a.this.hOX.login_user_info.is_live_admin = 1;
                                    a.this.hOY.aR(a.this.hOX.user_info.user_id, a.this.hOZ);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hOX.user_info.getNameShow()));
                    } else if (cks()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.6
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.login_user_info != null) {
                                    a.this.hOX.login_user_info.is_live_admin = 0;
                                    a.this.hOY.aS(a.this.hOX.user_info.user_id, a.this.hOZ);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hOX.user_info.getNameShow()));
                    } else if (ckt()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0678a() { // from class: com.baidu.tieba.ala.liveroom.q.a.7
                            @Override // com.baidu.tieba.ala.liveroom.q.a.InterfaceC0678a
                            public void onConfirm() {
                                if (a.this.hOX != null && a.this.hOX.login_user_info != null) {
                                    a.this.hOX.login_user_info.is_live_admin = 0;
                                    a.this.hOY.wg(a.this.hOZ);
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bZE) {
                this.hOY.onCancel();
            }
        }
    }

    private void a(final InterfaceC0678a interfaceC0678a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0678a != null) {
                    interfaceC0678a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.a.9
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
        this.hOX = personUserData;
        this.bpf = z;
        this.aFb = str;
        if (this.hOX != null && this.hOX.user_info != null && this.hOX.user_info.extInfoJson != null) {
            if (this.hOX.user_info.extInfoJson.optInt("is_mysterious_man") == 1) {
                this.hOZ = 1;
            }
        }
        if (cku() || ckv()) {
            we(8);
            wf(8);
        } else if (ckp()) {
            we(8);
            this.hOT.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (ckq()) {
            we(0);
            this.hOS.setText(a.h.ala_person_relieve_forbidden_this);
            this.hOT.setText(a.h.ala_person_forbid_forever);
        } else {
            we(0);
            this.hOS.setText(a.h.ala_person_forbid_this);
            this.hOT.setText(a.h.ala_person_forbid_forever);
        }
        if (cko()) {
            this.hOU.setVisibility(8);
            this.hOW.setVisibility(8);
        } else if (cks()) {
            this.hOU.setText(a.h.ala_person_fire_admin);
        } else if (ckr()) {
            this.hOU.setText(a.h.ala_person_appoint_admin);
        } else if (cku() && ckt()) {
            this.hOU.setText(a.h.ala_person_resign_admin);
        } else {
            this.hOU.setVisibility(8);
            this.hOW.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hOY = bVar;
    }

    private boolean cko() {
        return (this.hOX == null || this.hOX.user_info == null || this.hOX.user_info.is_block <= 0) ? false : true;
    }

    private boolean ckp() {
        return (this.hOX == null || this.hOX.user_info == null || this.hOX.user_info.is_block != 2) ? false : true;
    }

    private boolean ckq() {
        return (this.hOX == null || this.hOX.user_info == null || this.hOX.user_info.is_block != 1) ? false : true;
    }

    private boolean ckr() {
        return this.hOX != null && this.hOX.user_info != null && this.bpf && this.hOX.user_info.is_live_admin == 0;
    }

    private boolean cks() {
        return this.hOX != null && this.hOX.user_info != null && this.bpf && this.hOX.user_info.is_live_admin == 1;
    }

    private boolean ckt() {
        return (this.hOX == null || this.hOX.login_user_info == null || this.bpf || this.hOX.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cku() {
        return (this.hOX == null || this.hOX.user_info == null || TextUtils.isEmpty(this.aFb) || !this.aFb.equals(this.hOX.user_info.user_id)) ? false : true;
    }

    private boolean ckv() {
        return (this.hOX == null || this.hOX.user_info == null || this.hOX.user_info.is_live_admin != 1) ? false : true;
    }

    private void we(int i) {
        this.hOS.setVisibility(i);
        this.hOV.setVisibility(i);
    }

    private void wf(int i) {
        this.hOT.setVisibility(i);
        this.hOW.setVisibility(i);
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
