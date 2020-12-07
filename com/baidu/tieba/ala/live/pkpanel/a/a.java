package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private TextView haR;
    private RecyclerView haS;
    private JSONObject haT;
    private com.baidu.tieba.ala.live.pkpanel.b.a haU;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.haT = jSONObject;
        this.mOrientation = i;
        parseData(this.haT);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.haR = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.haR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.haS = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.haS.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.haU != null) {
            this.title.setText(this.haU.mTitle);
            bVar.setData(this.haU.gGo);
        }
        this.haS.setAdapter(bVar);
    }

    public void RU() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        wf(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.haU == null) {
            this.haU = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.haU.parseData(jSONObject);
    }

    private void wf(int i) {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (i == 1) {
                attributes.height = -2;
                attributes.width = -2;
            } else {
                attributes.width = -2;
                attributes.height = c(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public boolean isShowing() {
        return this.mDialog != null && this.mDialog.isShowing();
    }

    public void hide() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public void wg(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            RU();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gGo;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gGo = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0677a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gGo != null) {
                if ((viewHolder instanceof c) && this.gGo.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gGo.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0677a) {
                    ((C0677a) viewHolder).a(a.this.haU);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.haU == null || a.this.haU.gGo == null) {
                return 0;
            }
            return a.this.haU.gGo.size() + 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return wh(i) ? 2 : 1;
        }

        private boolean wh(int i) {
            return (a.this.haU == null || a.this.haU.gGo == null || a.this.haU.gGo.size() != i) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView egV;
        private TextView haW;
        private HeadImageView haX;
        private TextView haY;
        private com.baidu.tieba.ala.live.pkpanel.b.b haZ;

        public c(@NonNull View view) {
            super(view);
            this.haX = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.egV = (TextView) view.findViewById(a.f.gift_name);
            this.haY = (TextView) view.findViewById(a.f.gift_type);
            this.haW = (TextView) view.findViewById(a.f.gift_describe);
            if (this.haX != null) {
                this.haX.setIsRound(true);
                this.haX.setAutoChangeStyle(false);
                this.haX.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.haZ = bVar;
            if (this.haZ != null && i < a.this.haU.gGo.size()) {
                if (TextUtils.isEmpty(this.haZ.icon)) {
                    this.haX.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.haX.setUrl(this.haZ.icon);
                    l.a(this.haX, this.haZ.icon, false, false);
                }
                this.egV.setText(this.haZ.name);
                this.haY.setText(this.haZ.type);
                this.haY.setTextColor(Color.parseColor(this.haZ.hbb));
                this.haW.setText(this.haZ.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0677a extends RecyclerView.ViewHolder {
        TextView haW;
        TextView title;

        public C0677a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.haW = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.haW.setText(aVar.hba);
            }
        }
    }
}
