package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i implements p {
    private int ava;
    HeadImageView ezL;
    ImageView ezM;
    TextView ezN;
    private com.baidu.adp.widget.a.a ezO = null;
    private a ezP = null;
    CreateGroupStepActivity ezl;
    private int ezp;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.ezl = null;
        this.mView = null;
        this.ezL = null;
        this.ezM = null;
        this.ezN = null;
        this.ezl = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.h.create_group_step3_view, (ViewGroup) null);
        this.ezM = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.ezL = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.ezN = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.ava = i2;
        this.ezp = i3;
    }

    public void aGS() {
        if (this.ezP != null) {
            this.ezP.cancel();
        }
        this.ezO = null;
        this.ezP = new a();
        this.ezP.execute(new Object[0]);
    }

    public ImageView aGT() {
        return this.ezM;
    }

    public TextView aGU() {
        return this.ezN;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGD() {
        this.ezM.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public void aGE() {
        this.ezl.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.ezl.getLayoutMode().aM(this.mView);
        this.ezL.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.k.X(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.ezL.setVisibility(0);
                i.this.ezO = new com.baidu.adp.widget.a.a(bitmap, false, (String) null);
                i.this.ezO.a(i.this.ezL);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getTitle() {
        return String.format(this.ezl.getPageContext().getString(d.j.group_create_step_photo), Integer.valueOf(this.ava));
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String aGG() {
        if (this.mIndex != this.ezp) {
            return this.ezl.getPageContext().getString(d.j.next_step);
        }
        return this.ezl.getPageContext().getString(d.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGH() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public int aGx() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.p
    public boolean aGI() {
        return true;
    }
}
