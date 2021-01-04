package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private TextView hmF;
    private RecyclerView hmG;
    private JSONObject hmH;
    private com.baidu.tieba.ala.live.pkpanel.b.a hmI;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.hmH = jSONObject;
        this.mOrientation = i;
        parseData(this.hmH);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.hmF = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.hmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.hmG = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.hmG.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.hmI != null) {
            this.title.setText(this.hmI.mTitle);
            bVar.setData(this.hmI.gSb);
        }
        this.hmG.setAdapter(bVar);
    }

    public void SY() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        wq(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.hmI == null) {
            this.hmI = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.hmI.parseData(jSONObject);
    }

    private void wq(int i) {
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

    public void wr(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            SY();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gSb;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gSb = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0669a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gSb != null) {
                if ((viewHolder instanceof c) && this.gSb.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gSb.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0669a) {
                    ((C0669a) viewHolder).a(a.this.hmI);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.hmI == null || a.this.hmI.gSb == null) {
                return 0;
            }
            return a.this.hmI.gSb.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return ws(i) ? 2 : 1;
        }

        private boolean ws(int i) {
            return (a.this.hmI == null || a.this.hmI.gSb == null || a.this.hmI.gSb.size() != i) ? false : true;
        }
    }

    /* loaded from: classes11.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView epX;
        private TextView hmK;
        private HeadImageView hmL;
        private TextView hmM;
        private com.baidu.tieba.ala.live.pkpanel.b.b hmN;

        public c(@NonNull View view) {
            super(view);
            this.hmL = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.epX = (TextView) view.findViewById(a.f.gift_name);
            this.hmM = (TextView) view.findViewById(a.f.gift_type);
            this.hmK = (TextView) view.findViewById(a.f.gift_describe);
            if (this.hmL != null) {
                this.hmL.setIsRound(true);
                this.hmL.setAutoChangeStyle(false);
                this.hmL.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.hmN = bVar;
            if (this.hmN != null && i < a.this.hmI.gSb.size()) {
                if (TextUtils.isEmpty(this.hmN.icon)) {
                    this.hmL.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.hmL.setUrl(this.hmN.icon);
                    m.a(this.hmL, this.hmN.icon, false, false);
                }
                this.epX.setText(this.hmN.name);
                this.hmM.setText(this.hmN.type);
                this.hmM.setTextColor(Color.parseColor(this.hmN.hmP));
                this.hmK.setText(this.hmN.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    class C0669a extends RecyclerView.ViewHolder {
        TextView hmK;
        TextView title;

        public C0669a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.hmK = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.hmK.setText(aVar.hmO);
            }
        }
    }
}
