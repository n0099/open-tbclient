package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dyQ;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dxF = false;
        this.dxE = 3;
        this.dwN = new TopicDetaiInputContainer(context);
        this.dyQ = ((TopicDetaiInputContainer) this.dwN).getInputView();
        ((TopicDetaiInputContainer) this.dwN).setHint(context.getString(R.string.say_your_point));
        this.dxG = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dyQ;
    }
}
